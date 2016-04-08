package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTreeInsertFixUpTest {

	@Test
	public void insertFixUpEmpty() {
		RbTree<String> classUnderTest = RbTreeGenerator.empty();
		classUnderTest.insertFixup(classUnderTest.getRoot());
		assertThat("null or root", classUnderTest.getRoot(), equalTo(null));

	}

	@Test
	public void insertFixUpOne() {
		RbTree<String> classUnderTest = RbTreeGenerator.one();
		classUnderTest.getRoot().setColor(Color.RED);
		classUnderTest.insertFixup(classUnderTest.getRoot());
		assertThat("root is black", classUnderTest.getRoot().getColor(), equalTo(Color.BLACK));
	}

	@Test
	public void insertFixUpSix() {
		RbTree<String> classUnderTest = RbTreeGenerator.six();
		RbTreeElement<String> element = classUnderTest.getRoot().getRight();
		String base = classUnderTest.getRoot().getElement();

		BasicRbTreeDecorator<String> child = new BasicRbTreeDecorator<String>(base + base);
		child.setColor(Color.RED);
		child.setParent(element);
		element.setRight(child);

		element = child;
		child = new BasicRbTreeDecorator<String>(base + base + base);
		child.setColor(Color.RED);
		child.setParent(element);
		element.setRight(child);

		classUnderTest.insertFixup(child);
		assertThat("root is black", classUnderTest.getRoot().getColor(), equalTo(Color.BLACK));
		redNodeCheck(classUnderTest.getRoot());
		blackPathCountCheck(classUnderTest.getRoot());
	}

	// Ricorda che Nodo Null == Nero (nessuna istruzione)
	
	// Entrambi i figli di un nodo rosso sono neri
	public void redNodeCheck(RbTreeElement<String> element) {
		if(element == null) {
			return;
		}
		
		if(element.isRed()) {
			boolean leftCheck = element.getLeft() == null ? true : element.getLeft().isBlack();
			boolean rightCheck = element.getRight() == null ? true : element.getRight().isBlack();
			assertThat("child left is black", leftCheck, equalTo(true));
			assertThat("child right is black", rightCheck, equalTo(true));
		}
		
		redNodeCheck(element.getLeft());
		redNodeCheck(element.getRight());
	}

	// Ogni percorso dalla radice ha lo stesso numero di Nodi Neri
	public int blackPathCountCheck(RbTreeElement<String> element) {
		int counter, counterL, counterR;
		if (element == null) {
			counter = 1;
			return counter;
		} else {
			counter = element.isBlack() ? 1 : 0;
			counterL = blackPathCountCheck(element.getLeft());
			counterR = blackPathCountCheck(element.getRight());
			assertThat("black count L/R are equal", counterL, equalTo(counterR));
			return counterL + counter;
		}
	}
}

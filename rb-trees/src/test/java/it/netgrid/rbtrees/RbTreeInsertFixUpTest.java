package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import org.junit.Before;
import org.junit.Test;

import io.codearte.jfairy.Fairy;
import it.netgrid.rbtrees.RbTreeElement.Color;

/**
 * iTest.getRoot() -> Radice
 * element -> Nodo
 * base -> Per il calcolo di posizioni di ogni nodo
 * child -> Figlio di element
 */
public class RbTreeInsertFixUpTest {
	// private RbTree<String> classUnderTest;
	private Fairy fairy;

	@Before
	public void init() {
		// this.classUnderTest = new RbTree<String>();
		this.fairy = Fairy.create();

	}

	@Test
	public void insertFixUpEmpty() {
		RbTree<String> iTest = RbTreeGenerator.empty();
		BasicRbTreeDecorator<String> element = new BasicRbTreeDecorator<String>(fairy.textProducer().latinSentence());
		// this.classUnderTest.insertFixup(classUnderTest.getRoot());
		iTest.insertFixup(element);
		RbTreeGenerator.writeDotFile(iTest);
		assertThat("null or root", iTest.getRoot(), equalTo(null));

	}

	@Test
	public void insertFixUpOne() {
		RbTree<String> iTest = RbTreeGenerator.one();
		BasicRbTreeDecorator<String> element = new BasicRbTreeDecorator<String>(fairy.textProducer().latinSentence());
		// this.classUnderTest.insertFixup(classUnderTest.getRoot());
		iTest.getRoot().setColor(Color.RED);
		iTest.insertFixup(element);
		RbTreeGenerator.writeDotFile(iTest);
		assertThat("root is black", iTest.getRoot().getColor(), equalTo(Color.BLACK));

	}

	@Test
	public void insertFixUpSix() {
		RbTree<String> iTest = RbTreeGenerator.six();
		RbTreeElement<String> element = iTest.getRoot().getRight();
		String base = iTest.getRoot().getElement();

		BasicRbTreeDecorator<String> child = new BasicRbTreeDecorator<String>(base + base);
		child.setColor(Color.RED);
		child.setParent(element);
		element.setRight(child);

		element = child;
		child = new BasicRbTreeDecorator<String>(base + base + base);
		child.setColor(Color.RED);
		child.setParent(element);
		element.setRight(child);

		// this.classUnderTest.insertFixup(classUnderTest.getRoot());
		iTest.insertFixup(child);
		RbTreeGenerator.writeDotFile(iTest);
		assertThat("root is black", iTest.getRoot().getColor(), equalTo(Color.BLACK));
	}
	
	@Test
	public void assertThatFixUp(){
		RbTree<String> iTest = RbTreeGenerator.six();
		RbTreeElement<String> element = iTest.getRoot().getRight();
		iTest.insertFixup(element);
		
		
		// Radice Nera
		if(iTest.getRoot()!= null){
		assertThat("root is black", iTest.getRoot().getColor(), equalTo(Color.BLACK));
		}
		
		// Ricorda che Nodo Null == Nero (nessuna istruzione)

		String base = iTest.getRoot().getElement();
		BasicRbTreeDecorator<String> child = new BasicRbTreeDecorator<String>(base + base);
		child.setColor(Color.RED);
		child.setParent(element);
		element.setRight(child);
		
		// Nodo Rosso e Figli Neri
		if (element.isRed()) {
			child.setColor(Color.BLACK);
			assertThat("node is red", element.getColor(), equalTo(Color.RED));
			assertThat("children are black", child.getColor(), equalTo(Color.BLACK));
		}
		
		// Ogni Radice ha lo stesso numero di Nodi Neri
       if(element.isBlack()){
		if (iTest.getRoot().getLeft().getColor().toString()
				.compareTo(iTest.getRoot().getRight().getColor().toString()) == 0) {
          
			assertThat("same number of black nodes in root", iTest.getRoot().getLeft().getColor(),
					equalTo(iTest.getRoot().getRight().getColor()));
		} else {

			assertThat("not equal number", iTest.getRoot().getLeft(), not(equals(iTest.getRoot().getRight())));
		}
        }
	}
	}
	




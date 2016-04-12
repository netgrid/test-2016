package it.netgrid.rbtrees;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import io.codearte.jfairy.Fairy;
import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTreeDeleteFixupTest {
	RbTree<String> classunderTest;
	private Fairy fairy;
	
	@Before
	public void init(){
		this.classunderTest= new RbTree<String>();
		this.fairy = Fairy.create();
	}
	
	@Test
	public void testNull() {
		 classunderTest = RbTreeGenerator.empty();
		this.classunderTest.deleteFixup(classunderTest.getRoot());
		//assertThat("null equals null", result, equalTo(0));
		assertThat("null root", classunderTest.getRoot(), equalTo(null));

		RbTreeGenerator.writeDotFile(classunderTest);

	}
	
	@Test
	public void testOne() {
		classunderTest = RbTreeGenerator.one();
		this.classunderTest.deleteFixup(classunderTest.getRoot());
		assertThat("root is black", classunderTest.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("null left", classunderTest.getRoot().getLeft(), equalTo(null));
		assertThat("null right", classunderTest.getRoot().getRight(), equalTo(null));
		RbTreeGenerator.writeDotFile(classunderTest);

		

	}

	@Test
	public void testSix() {
		classunderTest = RbTreeGenerator.six();
		this.classunderTest.deleteFixup(classunderTest.getRoot().getLeft().getLeft());
		//this.classunderTest.deleteFixup(classunderTest.getRoot());
		assertThat("root is black", classunderTest.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("not null left", classunderTest.getRoot().getLeft(), notNullValue());
		assertThat("not null right", classunderTest.getRoot().getRight(), notNullValue());
		assertThat("not equal", classunderTest.getRoot().getLeft(), not(equals(classunderTest.getRoot().getRight())));
		redNodeCheck(classunderTest.getRoot());
		blackPathCountCheck(classunderTest.getRoot());
		RbTreeGenerator.writeDotFile(classunderTest);
		
	}

	@Test
	public void testSpec() {
		classunderTest = RbTreeGenerator.six();
		this.classunderTest.deleteFixup(classunderTest.getRoot().getLeft().getLeft());
		assertThat("root is black", classunderTest.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("null left", classunderTest.getRoot().getLeft(), equalTo(null));
		assertThat("null right", classunderTest.getRoot().getRight(), equalTo(null));
		//blackPathCountCheck(classunderTest.getRoot());
		RbTreeGenerator.writeDotFile(classunderTest);
	}

	public void redNodeCheck(RbTreeElement<String> element) {
		if (element == null) {
			return;
		}

		if (element.isRed()) {
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



		
	
  



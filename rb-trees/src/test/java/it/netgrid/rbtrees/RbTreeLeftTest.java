package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import io.codearte.jfairy.Fairy;
import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTreeLeftTest {
	RbTree<String> classUnderTest;

	private Fairy fairy;
	
	@Before
	public void init(){
		this.classUnderTest = new RbTree<String>();
		this.fairy = Fairy.create();
	}
	
	
	@Test
	public void testLeftRotate() {
			classUnderTest =RbTreeGenerator.one();//crea un albero con un nodo
			this.classUnderTest.leftRotate(classUnderTest.getRoot());
			assertThat("root is black", classUnderTest.getRoot().getColor(), equalTo(Color.BLACK));
			assertThat("null left", classUnderTest.getRoot().getLeft(), equalTo(null));
			assertThat("null right", classUnderTest.getRoot().getRight(), equalTo(null));
	}
}

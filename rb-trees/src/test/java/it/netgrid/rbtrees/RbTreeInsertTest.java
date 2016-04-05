package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import io.codearte.jfairy.Fairy;

public class RbTreeInsertTest {

	private RbTree<BasicRbTreeDecorator<Object>> classUnderTest;
	private Fairy fairy;
	
	@Before
	public void init() {
		this.classUnderTest = new RbTree<BasicRbTreeDecorator<Object>>();
	}
	
	@Test
	public void testInsertEmpty() {		
		// albero vuoto
		RbTree<String> treeTest = RbTreeGenerator.empty();
		
		// elemento da inserire
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>("test");
		treeTest.insert(elementTest);
		assertThat("one element (root)", treeTest.getRoot(), notNullValue());
	}
	
	
	@Test
	public void testInsertOne() {		
		// albero con un elemento
		RbTree<String> treeTest = RbTreeGenerator.one();
		
		// elemento da inserire
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>("test");
		String eTest = elementTest.toString();
		treeTest.insert(elementTest);
		
		// dipende dall' albero generato casulamente
		if (treeTest.getRoot().toString().compareTo(elementTest.getElement().toString()) == -1) {
			assertThat("element appended", treeTest.getRoot().getLeft(), notNullValue());
		}
		else {
			assertThat("element appended", treeTest.getRoot().getRight(), notNullValue());
		}
		

	}
	
	@Test
	public void testInsertSix() {
		// albero con 6 elementi
		RbTree<String> treeTest = RbTreeGenerator.six();
		
		// elemento da inserire
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>("test");
		treeTest.insert(elementTest);
		
		assertThat("not null right right", treeTest.getRoot().getRight().getRight(), notNullValue());
		
	}

	
	
	
	
	
}

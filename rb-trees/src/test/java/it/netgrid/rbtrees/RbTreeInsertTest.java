package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.apache.commons.lang3.RandomStringUtils;
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
	public void testInsertEmpty() {		//albero vuoto		
		RbTree<String> treeTest = RbTreeGenerator.empty();
		
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>(RandomStringUtils.randomAlphabetic(10));
		treeTest.insert(elementTest);
		assertThat("one element (root)", treeTest.getRoot(), notNullValue());
		
	}
		
	@Test
	public void testInsertOne() {		//albero con un elemento		
		RbTree<String> treeTest = RbTreeGenerator.one();
		
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>(RandomStringUtils.randomAlphabetic(10));
		treeTest.insert(elementTest);
		
		if (treeTest.getRoot().toString().compareTo(elementTest.getElement().toString()) == -1) {
			assertThat("element appended in left", treeTest.getRoot().getLeft(), notNullValue());
			assertThat("element absent in right", treeTest.getRoot().getRight(), equalTo(null));
		}
		else {
			assertThat("element appended in right", treeTest.getRoot().getRight(), notNullValue());
			assertThat("element absent in left", treeTest.getRoot().getLeft(), equalTo(null));
		}
		
	}
	
	@Test
	public void testInsertSix() {		//albero con 6 elementi
		RbTree<String> treeTest = RbTreeGenerator.six();
		
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>(RandomStringUtils.randomAlphabetic(10));
		treeTest.insert(elementTest);
		
		
		// ROOT LEFT
		
		// insert in left-left-left
		if (treeTest.getRoot().getLeft().getLeft().toString().compareTo(elementTest.getElement().toString()) == -1) {
			assertThat("not null in left-left-left", treeTest.getRoot().getLeft().getLeft().getLeft(), notNullValue());
		}		
		// insert in left-left-right
		else if (treeTest.getRoot().getLeft().getLeft().toString().compareTo(elementTest.getElement().toString()) == 1) {
			assertThat("not null in left-left-right", treeTest.getRoot().getLeft().getLeft().getRight(), notNullValue());
		}		
		// insert in left-right-left
		else if (treeTest.getRoot().getLeft().getRight().toString().compareTo(elementTest.getElement().toString()) == -1) {
			assertThat("not null in left-right-left", treeTest.getRoot().getLeft().getRight().getLeft(), notNullValue());
		}		
		// insert in left-right-right
		else if (treeTest.getRoot().getLeft().getRight().toString().compareTo(elementTest.getElement().toString()) == 1) {
			assertThat("not null in left-right-right", treeTest.getRoot().getLeft().getRight().getRight(), notNullValue());
		}
			
		
		// ROOT RIGHT
		
		// insert in right-left-left
		else if (treeTest.getRoot().getRight().getLeft().toString().compareTo(elementTest.getElement().toString()) == -1) {
			assertThat("not null in right-left-left", treeTest.getRoot().getRight().getLeft().getLeft(), notNullValue());
		}		
		// insert in right-left-right
		else if (treeTest.getRoot().getRight().getLeft().toString().compareTo(elementTest.getElement().toString()) == 1) {
			assertThat("not null in right-left-right", treeTest.getRoot().getRight().getLeft().getRight(), notNullValue());
		}		
		// insert in right-right
		else {
			assertThat("not null in right-right", treeTest.getRoot().getRight().getRight(), notNullValue());
		}
	
	}

	
	
	
	
	
}

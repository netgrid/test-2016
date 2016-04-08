package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class RbTreeDeleteTest {
	
	@Test
	public void testEmpty() {
		RbTree<String> classUnderTest = RbTreeGenerator.empty();
		assertThat("tree is empty", classUnderTest.delete(classUnderTest.getRoot()), equalTo(null));
	}
	
	@Test
	public void testRoot() {
		RbTree<String> classUnderTest = RbTreeGenerator.one();
		assertThat("can't delete root", classUnderTest.delete(classUnderTest.getRoot()), equalTo(null));	
	}
	
	@Test
	public void testNoSon() {
		RbTree<String> classUnderTest = RbTreeGenerator.six();
		RbTreeElement<String> expected = classUnderTest.getRoot().getLeft().getLeft();
		assertThat("node deleted", classUnderTest.delete(classUnderTest.getRoot().getLeft().getLeft()), equalTo(expected));
	}
	
	@Test
	public void testOneSon() {
		RbTree<String> classUnderTest = RbTreeGenerator.six();
		RbTreeElement<String> expected = classUnderTest.getRoot().getRight();
		assertThat("node deleted", classUnderTest.delete(classUnderTest.getRoot().getRight()), equalTo(expected));
	}
	
	@Test
	public void testTwoSon() {
		RbTree<String> classUnderTest = RbTreeGenerator.six();
		RbTreeElement<String> expected = classUnderTest.getRoot().getLeft().getRight();
		assertThat("node deleted", classUnderTest.delete(classUnderTest.getRoot().getLeft()), equalTo(expected));
	}
	
}

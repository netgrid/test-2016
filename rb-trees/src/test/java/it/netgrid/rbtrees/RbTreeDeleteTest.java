package it.netgrid.rbtrees;


import io.codearte.jfairy.Fairy;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;



import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class RbTreeDeleteTest {

	private RbTree<String> classUnderTest;
	private Fairy fairy;
	
	
	@Test
	public void testEmpty() {
		RbTree<String> output = RbTreeGenerator.empty();
		assertThat("tree is empty", output.delete(output.getRoot()), equalTo(null));
	}
	
	
	@Test
	public void testOne() {
		RbTree<String> output = RbTreeGenerator.one();
		assertThat("can't delete root", output.delete(output.getRoot()), equalTo(null));	
	}
	
	
	
	@Test
	public void testNoSon() {
		RbTree<String> output = RbTreeGenerator.six();
		RbTreeElement<String> expected = output.getRoot().getLeft().getLeft();
		assertThat("node deleted", output.delete(output.getRoot().getLeft().getLeft()), equalTo(expected));
	}
	
	@Test
	public void testOneSon() {
		RbTree<String> output = RbTreeGenerator.six();
		RbTreeElement<String> expected = output.getRoot().getRight().getLeft();
		RbTreeElement<String> result = output.delete(output.getRoot().getRight());
		assertThat("node deleted", output.delete(output.getRoot().getRight()), equalTo(expected));
		
	}
	@Test
	public void testTwoSon() {
		RbTree<String> output = RbTreeGenerator.six();
		RbTreeElement<String> expected = output.getRoot().getLeft().getRight();
		RbTreeElement<String> result = output.delete(output.getRoot().getLeft());
		assertThat("node deleted", output.delete(output.getRoot().getLeft()), equalTo(expected));
		
	}
	
}


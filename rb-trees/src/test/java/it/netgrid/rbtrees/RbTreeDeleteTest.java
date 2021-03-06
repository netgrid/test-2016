package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class RbTreeDeleteTest {
	
	
	@Test
	public void testEmpty() {
		RbTree<String> output = RbTreeGenerator.empty();
		assertThat("tree is empty", output.delete(output.getRoot()), equalTo(null));
	}
	
	
	@Test
	public void testRoot() {
		RbTree<String> output = RbTreeGenerator.one();
		assertThat("can't delete root", output.delete(output.getRoot()), equalTo(null));	
	}
	
	
	
	@Test
	public void testNoSon() {
		RbTree<String> output = RbTreeGenerator.six();
		RbTreeGenerator.writeDotFile(output);
		RbTreeElement<String> expected = output.getRoot().getLeft().getLeft();
		assertThat("node deleted", output.delete(output.getRoot().getLeft().getLeft()), equalTo(expected));
	}
	
	@Test
	public void testOneSon() {
		RbTree<String> output = RbTreeGenerator.six();
		RbTreeGenerator.writeDotFile(output);
		RbTreeElement<String> expected = output.getRoot().getRight();
		assertThat("node deleted", output.delete(output.getRoot().getRight()), equalTo(expected));
		
		
	}
	@Test
	public void testTwoSon() {
		RbTree<String> output = RbTreeGenerator.six();
		RbTreeElement<String> expected = output.getRoot().getLeft().getRight();
		assertThat("node deleted", output.delete(output.getRoot().getLeft()), equalTo(expected));
		
		
	}
	
}


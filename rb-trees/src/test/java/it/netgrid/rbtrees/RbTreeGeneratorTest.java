package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTreeGeneratorTest {
	
	@Test
	public void testEmpty() {
		RbTree<String> output = RbTreeGenerator.empty();
		assertThat("null root", output.getRoot(), equalTo(null));
	}
	
	@Test
	public void testOne() {
		RbTree<String> output = RbTreeGenerator.one();
		assertThat("root is black", output.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("null left", output.getRoot().getLeft(), equalTo(null));
		assertThat("null right", output.getRoot().getRight(), equalTo(null));
		
	}
	
	@Test
	public void testSix() {
		RbTree<String> output = RbTreeGenerator.six();
		assertThat("root is black", output.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("not null left", output.getRoot().getLeft(), notNullValue());
		assertThat("not null right", output.getRoot().getRight(), notNullValue());
		assertThat("not equal", output.getRoot().getLeft(), not(equals(output.getRoot().getRight())));	
	}
}

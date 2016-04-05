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
	
	@Test
	public void testSixMaxAndMin() {
		RbTree<String> output = RbTreeGenerator.six();
		
		this.testSixMaxAndMinSubTree(output.getRoot(), 0);
	}
	
	private void testSixMaxAndMinSubTree(RbTreeElement<String> parent, int depth) {
		RbTreeElement<String> left = parent.getLeft();
		RbTreeElement<String> right = parent.getRight();
		
		// parent is greater
		boolean leftResult = left == null ? true : parent.compareTo(left.getElement()) > 0;
		// parent is smaller
		boolean rightResult = right == null ? true : parent.compareTo(right.getElement()) < 0;
		assertThat(String.format("%d left is minor", depth), leftResult, equalTo(true));
		assertThat(String.format("%d right is major", depth), rightResult, equalTo(true));
		
		if(left != null) {
			this.testSixMaxAndMinSubTree(left, depth+1);
		}
		
		if(right != null) {
			this.testSixMaxAndMinSubTree(right, depth+1);
		}
	}
}

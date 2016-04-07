package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import io.codearte.jfairy.Fairy;
import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTreeLeftRotateTest {
	private RbTreeGenerator classUnderTest;
	private Fairy fairy = Fairy.create();
	BasicRbTreeDecorator<String> element = new BasicRbTreeDecorator<String>(fairy.textProducer().latinSentence());
	
	@Test
	public void testOne() {
		RbTree<String> output = RbTreeGenerator.six();
		output.leftRotate(output.getRoot());
		
		
	}
	
	@Test
	public void testTwo() {
		RbTree<String> output = RbTreeGenerator.six();
		output.rightRotate(output.getRoot());
		
		
	}
	
	@Test
	public void testThree() {
		RbTree<String> output = RbTreeGenerator.six();
		output.rightRotate(output.getRoot().getLeft());
		
		
	}
	
	@Test
	public void testFour() {
		RbTree<String> output = RbTreeGenerator.six();
		output.leftRotate(output.getRoot().getLeft());
		
		
	}
	
	private static String multi(String base, int multi) {
		String retval = "";
		for(int i=0; i<multi; i++) {
			retval += base;
		}
		
		return retval;
	}
	
}

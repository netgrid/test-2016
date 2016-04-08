package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import io.codearte.jfairy.Fairy;

public class RbTreeLeftRotateTest {
	private RbTree<String> classUnderTest;
	private Fairy fairy = Fairy.create();
	BasicRbTreeDecorator<String> element = new BasicRbTreeDecorator<String>(fairy.textProducer().latinSentence());
	
	@Before
	public void init() {
		this.fairy = Fairy.create();
		
	}
	
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
	public void testLeftRotateSix(){
		classUnderTest =RbTreeGenerator.six();
		RbTreeElement x = classUnderTest.getRoot().getLeft();
		RbTreeElement y = classUnderTest.getRoot().getLeft().getRight();
		RbTreeElement z = classUnderTest.getRoot().getLeft().getLeft();
		classUnderTest.leftRotate(classUnderTest.getRoot().getLeft());
		assertThat("rotated x", classUnderTest.getRoot().getLeft().getLeft(), equalTo(x));
		assertThat("rotated y", classUnderTest.getRoot().getLeft(), equalTo(y));
		assertThat("rotated z", classUnderTest.getRoot().getLeft().getLeft().getLeft(), equalTo(z)); 
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

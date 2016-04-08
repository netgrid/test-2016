package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import io.codearte.jfairy.Fairy;

public class RbTreeLeftRotateTest {
	
	private Fairy fairy = Fairy.create();
	BasicRbTreeDecorator<String> element = new BasicRbTreeDecorator<String>(fairy.textProducer().latinSentence());
	
	@Test
	public void testOne() {
		RbTree<String> classUnderTest = RbTreeGenerator.six();
		classUnderTest.leftRotate(classUnderTest.getRoot());
		
		
	}
	
	@Test
	public void testTwo() {
		RbTree<String> classUnderTest = RbTreeGenerator.six();
		classUnderTest.rightRotate(classUnderTest.getRoot());
		
		
	}
	
	@Test
	public void testLeftRotateSix(){
		RbTree<String> classUnderTest =RbTreeGenerator.six();
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
		RbTree<String> classUnderTest = RbTreeGenerator.six();
		classUnderTest.leftRotate(classUnderTest.getRoot().getLeft());
		
		
	}	
}

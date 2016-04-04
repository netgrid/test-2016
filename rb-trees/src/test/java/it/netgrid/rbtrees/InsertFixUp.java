package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import io.codearte.jfairy.Fairy;
import it.netgrid.rbtrees.RbTreeElement.Color;

public class InsertFixUp {
	private RbTree<BasicRbTreeDecorator<Object>> classUnderTest;
	private Fairy fairy;
	private RbTreeElement<BasicRbTreeDecorator<Object>> root;
	
	@Before
	public void init() {
		this.classUnderTest = new RbTree<BasicRbTreeDecorator<Object>>();
		this.fairy = Fairy.create();
	}
	/**
	@Test
	public void testNullCompareToNull() {
		int result = this.classUnderTest.compareTo(null);
		assertThat("null equals null", result, equalTo(0));
	}
	
	@Test
	public void testNullCompareToEmptyString() {
		int result = this.classUnderTest.compareTo("");
		assertThat("null smaller than empty", result, equalTo(-1));
	}
	
	@Test
	public void testInertNotEmptyCompareTo() {
		String item = this.fairy.textProducer().latinSentence();
		String compare = this.fairy.textProducer().latinSentence();
		this.classUnderTest = new RbTree<BasicRbTreeDecorator<Object>>(item);
		int result = this.classUnderTest.compareTo(compare);
		int check = item.compareTo(compare);
		
		assertThat("same results", result, equalTo(check));
	}
*/
	public void insertFixup(RbTreeElement<BasicRbTreeDecorator<Object>> element) {
		RbTreeElement<BasicRbTreeDecorator<Object>> y = null;
		while (element.getParent().isRed()) {
			if (element.getParent() == element.getParent().getParent().getLeft()) {
				y = element.getParent().getParent().getRight();

				if (y.isRed()) {
					element.getParent().setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					element.getParent().getParent().setColor(Color.RED);
					element = element.getParent().getParent();

				} else if (element == element.getParent().getRight()){
					element = element.getParent();
				
					leftRotate(element);
				} else {
					element.getParent().setColor(Color.BLACK);
					element.getParent().getParent().setColor(Color.RED);
					rightRotate(element.getParent().getParent());

				}
			} else {
				y = element.getParent().getParent().getLeft();
			}
			if (y.isRed()) {
				element.getParent().setColor(Color.BLACK);
				y.setColor(Color.BLACK);
				element.getParent().getParent().setColor(Color.RED);
				element = element.getParent().getParent();

			} else if (element == element.getParent().getLeft()) {
				element = element.getParent();
				rightRotate(element);
			} else {
				element.getParent().setColor(Color.BLACK);
				element.getParent().getParent().setColor(Color.RED);
				leftRotate(element.getParent().getParent());
			}
		}
		root.setColor(Color.BLACK);
	}
}

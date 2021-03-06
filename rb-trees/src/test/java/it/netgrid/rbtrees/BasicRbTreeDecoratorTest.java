package it.netgrid.rbtrees;

import org.junit.Before;
import org.junit.Test;

import io.codearte.jfairy.Fairy;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class BasicRbTreeDecoratorTest {

	private BasicRbTreeDecorator<Object> classUnderTest;
	private Fairy fairy;
	
	@Before
	public void init() {
		this.classUnderTest = new BasicRbTreeDecorator<Object>(null);
		this.fairy = Fairy.create();
	}
	
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
		this.classUnderTest = new BasicRbTreeDecorator<Object>(item);
		int result = this.classUnderTest.compareTo(compare);
		int check = item.compareTo(compare);
		
		assertThat("same results", result, equalTo(check));
	}
}

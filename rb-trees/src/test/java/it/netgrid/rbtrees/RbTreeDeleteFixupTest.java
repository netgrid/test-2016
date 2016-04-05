package it.netgrid.rbtrees;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import io.codearte.jfairy.Fairy;

public class RbTreeDeleteFixupTest {
	RbTree<String> classunderTest;
	private Fairy fairy;
	
	@Before
	public void init(){
		this.classunderTest= new RbTree<String>();
		this.fairy = Fairy.create();
	}
	
	@Test
	public void testNull() {
		RbTree<String> result = RbTreeGenerator.empty();
		this.classunderTest.deleteFixup(result.getRoot());
		//assertThat("null equals null", result, equalTo(0));
		assertThat("null root", result.getRoot(), equalTo(null));
	}
	/*
	@Test
	public void testOne() {
		int result = this.classunderTest.compareTo(null);
		
		this.classunderTest.deleteFixup(element);
		assertThat("null equals null", result, equalTo(0));
	}
	@Test
	public void testSix() {
		int result = this.classunderTest.compareTo(null);
		
		this.classunderTest.deleteFixup(element);
		assertThat("null equals null", result, equalTo(0));
		
	}
*/
}


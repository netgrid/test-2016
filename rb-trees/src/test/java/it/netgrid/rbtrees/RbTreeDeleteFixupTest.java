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
	public void testNullCompareToNull() {
		int result = this.classunderTest.compareTo(null);
		
		this.classunderTest.deleteFixup(element);
		assertThat("null equals null", result, equalTo(0));
	}
}

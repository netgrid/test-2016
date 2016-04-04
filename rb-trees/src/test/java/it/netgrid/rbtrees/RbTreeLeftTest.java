package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Before;

import io.codearte.jfairy.Fairy;

public class RbTreeLeftTest {
	RbTree<BasicRbTreeDecorator<Object>> classUnderTest;
	
	private Fairy fairy;
	
	@Before
	public void init(){
		this.classUnderTest =new RbTree<BasicRbTreeDecorator<Object>>();
	}
}

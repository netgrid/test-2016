package it.netgrid.rbtrees;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Before;

import io.codearte.jfairy.Fairy;

public class RbTreeDeleteFixupTest {
	RbTree<BasicRbTreeDecorator<Object>> classunderTest;
	private Fairy fairy;
	
	@Before
	public void init(){
		this.classunderTest= new RbTree<BasicRbTreeDecorator<Object>>();
	}
}

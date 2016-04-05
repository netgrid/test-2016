package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import io.codearte.jfairy.Fairy;
import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTreeLeftRotateTest {
	private RbTreeGenerator classUnderTest;
	private Fairy fairy;
	RbTree<String> tree = new RbTree<String>();
	BasicRbTreeDecorator<String> element = new BasicRbTreeDecorator<String>(fairy.textProducer().latinSentence());
	
	
	
}

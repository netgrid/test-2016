package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import io.codearte.jfairy.Fairy;
import it.netgrid.rbtrees.RbTreeElement.Color;

@SuppressWarnings("unused")
public class RbTreeGetTest {
	RbTree<String> classunderTest;
	private Fairy Fairy;
	
	@Before
	public void init() {
		this.classunderTest = new RbTree<String>();
		this.Fairy = Fairy.create();
	}
	
	@Test
	public void testNull() {
		String base = Fairy.textProducer().latinSentence();
		classunderTest = RbTreeGenerator.empty();
		this.classunderTest.get(classunderTest.getRoot().getLeft().setElement("prova"));
		assertThat("null root", classunderTest.getRoot(), equalTo(null));
	}
	
	@Test
	public void testOne() {
		classunderTest = RbTreeGenerator.one();
		assertThat("root is black", classunderTest.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("null left", classunderTest.getRoot().getLeft(), equalTo(null));
		assertThat("null right", classunderTest.getRoot().getRight(), equalTo(null));
		
	}
	
	@Test
	public void testSix() {
		classunderTest = RbTreeGenerator.six();
		assertThat("root is black", classunderTest.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("not null left", classunderTest.getRoot().getLeft(), notNullValue());
		assertThat("not null right", classunderTest.getRoot().getRight(), notNullValue());
		assertThat("not equal", classunderTest.getRoot().getLeft(), not(equals(classunderTest.getRoot().getRight())));	
	}
	
}

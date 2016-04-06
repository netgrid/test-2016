package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Before;
import org.junit.Test;

import io.codearte.jfairy.Fairy;
import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTreeInsertFixUpTest{
	private RbTree<String> classUnderTest;
	
	private Fairy fairy;
	
	@Before
	public void init() {
		this.classUnderTest = new RbTree<String>();
		this.fairy = Fairy.create();
		
	}
	
	@Test
	public void insertFixUpEmpty() {
		classUnderTest = RbTreeGenerator.empty();
		BasicRbTreeDecorator<String> element = new BasicRbTreeDecorator<String>(fairy.textProducer().latinSentence());
		this.classUnderTest.insertFixup(classUnderTest.getRoot());
		assertThat("null root", classUnderTest.getRoot(), equalTo(null));
	}
	
	@Test
	public void insertFixUpOne() {
		classUnderTest = RbTreeGenerator.one();
		BasicRbTreeDecorator<String> element = new BasicRbTreeDecorator<String>(fairy.textProducer().latinSentence());
		this.classUnderTest.insertFixup(classUnderTest.getRoot());
		assertThat("root is black", classUnderTest.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("null left", classUnderTest.getRoot().getLeft(), equalTo(null));
		assertThat("null right", classUnderTest.getRoot().getRight(), equalTo(null));
		
	}
	
	@Test
	public void insertFixUpSix() {
		classUnderTest = RbTreeGenerator.six();
		BasicRbTreeDecorator<String> element = new BasicRbTreeDecorator<String>(fairy.textProducer().latinSentence());
		this.classUnderTest.insertFixup(classUnderTest.getRoot());
		assertThat("root is black", classUnderTest.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("not null left", classUnderTest.getRoot().getLeft(), notNullValue());
		assertThat("not null right", classUnderTest.getRoot().getRight(), notNullValue());
		assertThat("not equal", classUnderTest.getRoot().getLeft(), not(equals(classUnderTest.getRoot().getRight())));	
	}
	
}

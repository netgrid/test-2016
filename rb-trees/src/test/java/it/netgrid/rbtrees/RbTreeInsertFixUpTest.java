package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Before;
import org.junit.Test;

import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTreeInsertFixUpTest {
	private RbTree<String> classUnderTest;
	//private Fairy fairy;
	
	@Before
	public void init() {
		this.classUnderTest = new RbTree<String>();
		
	}
	@Test
	public void insertFixUpEmpty() {
		RbTree<String> output = RbTreeGenerator.empty();
		this.classUnderTest.insertFixup(output.getRoot());
		assertThat("null root", output.getRoot(), equalTo(null));
	}
	
	@Test
	public void insertFixUpOne() {
		RbTree<String> output = RbTreeGenerator.one();
		this.classUnderTest.insertFixup(output.getRoot());
		assertThat("root is black", output.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("null left", output.getRoot().getLeft(), equalTo(null));
		assertThat("null right", output.getRoot().getRight(), equalTo(null));
		
	}
	
	@Test
	public void insertFixUpSix() {
		RbTree<String> output = RbTreeGenerator.six();
		this.classUnderTest.insertFixup(output.getRoot());
		assertThat("root is black", output.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("not null left", output.getRoot().getLeft(), notNullValue());
		assertThat("not null right", output.getRoot().getRight(), notNullValue());
		assertThat("not equal", output.getRoot().getLeft(), not(equals(output.getRoot().getRight())));	
	}
}

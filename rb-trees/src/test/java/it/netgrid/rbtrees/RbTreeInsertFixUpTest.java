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
	//private RbTree<String> classUnderTest;	
	private Fairy fairy;
	
	@Before
	public void init() {
		//this.classUnderTest = new RbTree<String>();
		this.fairy = Fairy.create();
		
	}
	
	@Test
	public void insertFixUpEmpty() {
		RbTree<String> iTest = RbTreeGenerator.empty();
		BasicRbTreeDecorator<String> element = new BasicRbTreeDecorator<String>(fairy.textProducer().latinSentence());
		//this.classUnderTest.insertFixup(classUnderTest.getRoot());
		iTest.insertFixup(element);
		RbTreeGenerator.writeDotFile(iTest);
		assertThat("null or root", iTest.getRoot(),equalTo(null));
		
	}
	
	@Test
	public void insertFixUpOne() {
		RbTree<String> iTest = RbTreeGenerator.one();
		BasicRbTreeDecorator<String> element = new BasicRbTreeDecorator<String>(fairy.textProducer().latinSentence());
		//this.classUnderTest.insertFixup(classUnderTest.getRoot());
		iTest.getRoot().setColor(Color.RED);
		iTest.insertFixup(element);
		RbTreeGenerator.writeDotFile(iTest);
		assertThat("root is black", iTest.getRoot().getColor(), equalTo(Color.BLACK));
		
	}
	
	@Test
	public void insertFixUpSix() {
		RbTree<String> iTest  = RbTreeGenerator.six();
		BasicRbTreeDecorator<String> element = new BasicRbTreeDecorator<String>(fairy.textProducer().latinSentence());
		//this.classUnderTest.insertFixup(classUnderTest.getRoot());
		iTest.insertFixup(element);
		RbTreeGenerator.writeDotFile(iTest);
		assertThat("root is black", iTest.getRoot().getColor(), equalTo(Color.BLACK));
		
		if (iTest.getRoot().getLeft().getLeft().toString().compareTo(element.getElement().toString()) == -1) {
			assertThat("not null in left-left-left", iTest.getRoot().getLeft().getLeft().getLeft(), notNullValue());
		}		
	
		else if (iTest.getRoot().getLeft().getLeft().toString().compareTo(element.getElement().toString()) == 1) {
			assertThat("not null in left-left-right", iTest.getRoot().getLeft().getLeft().getRight(), notNullValue());
		}		
		
		else if (iTest.getRoot().getLeft().getRight().toString().compareTo(element.getElement().toString()) == -1) {
			assertThat("not null in left-right-left", iTest.getRoot().getLeft().getRight().getLeft(), notNullValue());
		}		
	
		else if (iTest.getRoot().getLeft().getRight().toString().compareTo(element.getElement().toString()) == 1) {
			assertThat("not null in left-right-right", iTest.getRoot().getLeft().getRight().getRight(), notNullValue());
		}
		
		else if (iTest.getRoot().getRight().getLeft().toString().compareTo(element.getElement().toString()) == -1) {
			assertThat("not null in right-left-left", iTest.getRoot().getRight().getLeft().getLeft(), notNullValue());
		}		
		
		else if (iTest.getRoot().getRight().getLeft().toString().compareTo(element.getElement().toString()) == 1) {
			assertThat("not null in right-left-right", iTest.getRoot().getRight().getLeft().getRight(), notNullValue());
		}		
	
		else {
			assertThat("null in right-right", iTest.getRoot().getRight().getRight(), equalTo(null));
		}
	
	
		assertThat("not equal", iTest.getRoot().getLeft(), not(equals(iTest.getRoot().getRight())));	
	}
	
}

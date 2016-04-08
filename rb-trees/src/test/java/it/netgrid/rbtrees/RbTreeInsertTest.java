package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import io.codearte.jfairy.Fairy;
import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTreeInsertTest {

	private Fairy fairy;
	
	@Before
	public void init() {
		this.fairy = Fairy.create();
	}
	
	
	// inserimento di un nodo in un albero vuoto
	@Test
	public void testInsertEmpty() {	
		RbTree<String> classUnderTest = RbTreeGenerator.empty();
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>(this.fairy.textProducer().latinSentence()); 
		classUnderTest.insert(elementTest);
		assertThat("one element", classUnderTest.getRoot(), notNullValue());
		assertThat("null left", classUnderTest.getRoot().getLeft(), equalTo(null));
		assertThat("null right", classUnderTest.getRoot().getRight(), equalTo(null));
	}
	
	
	// inserimento di un oggetto nullo in un albero
	@Test 
	public void testInsertNull() {
		RbTree<String> classUnderTest = RbTreeGenerator.one();		
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>(null); 	
		classUnderTest.insert(elementTest);
	}
	

	// inserimento di un nodo in un albero composto da un solo elemento
	@Test
	public void testInsertOne() {		
		RbTree<String> classUnderTest = RbTreeGenerator.one();		
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>(this.fairy.textProducer().latinSentence()); 
		classUnderTest.insert(elementTest);
		
		// ROOT LEFT
		if (classUnderTest.getRoot().toString().compareTo(elementTest.getElement().toString()) == -1) {
			assertThat("element appended in left", classUnderTest.getRoot().getLeft(), notNullValue());
			assertThat("element appended is RED", classUnderTest.getRoot().getLeft().getColor(), equalTo(Color.RED));
			assertThat("element absent in right", classUnderTest.getRoot().getRight(), equalTo(null));
		}
		
		// ROOT RIGHT
		else {
			assertThat("element appended in right", classUnderTest.getRoot().getRight(), notNullValue());
			assertThat("element appended is RED", classUnderTest.getRoot().getRight().getColor(), equalTo(Color.RED));
			assertThat("element absent in left", classUnderTest.getRoot().getLeft(), equalTo(null));
		}
	}
		
	
	// inserimento di un nodo in un albero composto da 6 elementi
	@Test
	public void testInsertSix() {
		RbTree<String> classUnderTest = RbTreeGenerator.six();		
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>(this.fairy.textProducer().latinSentence()); 
		classUnderTest.insert(elementTest);
		assertThat("not null in right-right", classUnderTest.getRoot().getRight().getRight(), notNullValue());
		assertThat("RED in right-right", classUnderTest.getRoot().getRight().getRight().getColor(), equalTo(Color.RED));
	}

}

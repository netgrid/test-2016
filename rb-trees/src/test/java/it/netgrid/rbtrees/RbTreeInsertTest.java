package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import io.codearte.jfairy.Fairy;
import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTreeInsertTest {

	private RbTree<BasicRbTreeDecorator<Object>> classUnderTest;
	private Fairy fairy;
	
	@Before
	public void init() {
		this.classUnderTest = new RbTree<BasicRbTreeDecorator<Object>>();
		this.fairy = Fairy.create();
		
	}
	
	
	// inserimento di un nodo in un albero vuoto
	@Test
	public void testInsertEmpty() {	
		RbTree<String> treeTest = RbTreeGenerator.empty();
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>(this.fairy.textProducer().latinSentence()); 
		treeTest.insert(elementTest);
		assertThat("one element (root)", treeTest.getRoot(), notNullValue());
		assertThat("null left", treeTest.getRoot().getLeft(), equalTo(null));
		assertThat("null right", treeTest.getRoot().getRight(), equalTo(null));
		
	}
	
	
	// inserimento di un nodo in un albero composto da un solo elemento
	@Test
	public void testInsertOne() {		
		RbTree<String> treeTest = RbTreeGenerator.one();		
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>(this.fairy.textProducer().latinSentence()); 
		treeTest.insert(elementTest);
		
		// ROOT LEFT
		if (treeTest.getRoot().toString().compareTo(elementTest.getElement().toString()) == -1) {
			assertThat("element appended in left", treeTest.getRoot().getLeft(), notNullValue());
			assertThat("element absent in right", treeTest.getRoot().getRight(), equalTo(null));
		}
		
		// ROOT RIGHT
		else {
			assertThat("element appended in right", treeTest.getRoot().getRight(), notNullValue());
			assertThat("element absent in left", treeTest.getRoot().getLeft(), equalTo(null));
		}
		
	}
	
	
	// inserimento di un oggetto nullo in un albero
	@Test (expected = NullPointerException.class)	// mi aspetto un' eccezione (NullPointerException) perchè non posso eseguire operazioni su oggetti nulli
	public void testInsertNull() {
		RbTree<String> treeTest = RbTreeGenerator.one();		
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>(null); 	
		treeTest.insert(elementTest);
		
	}
	
	
	// inserimento di un nodo in un albero composto da 6 elementi
	@Test
	public void testInsertSix() {
		RbTree<String> treeTest = RbTreeGenerator.six();		
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>(this.fairy.textProducer().latinSentence()); 
		treeTest.insert(elementTest);
		
		
		// ROOT LEFT
		
		// insert in left-left-left
		if (treeTest.getRoot().getLeft().getLeft().toString().compareTo(elementTest.getElement().toString()) == -1) {
			assertThat("not null in left-left-left", treeTest.getRoot().getLeft().getLeft().getLeft(), notNullValue());
			assertThat("null in left-left-right", treeTest.getRoot().getLeft().getLeft().getRight(), equalTo(null));
		}
		// insert in left-left-right
		else if (treeTest.getRoot().getLeft().getLeft().toString().compareTo(elementTest.getElement().toString()) == 1) {
			assertThat("not null in left-left-right", treeTest.getRoot().getLeft().getLeft().getRight(), notNullValue());
			assertThat("null in left-left-left", treeTest.getRoot().getLeft().getLeft().getLeft(), equalTo(null));
		}		
		// insert in left-right-left
		else if (treeTest.getRoot().getLeft().getRight().toString().compareTo(elementTest.getElement().toString()) == -1) {
			assertThat("not null in left-right-left", treeTest.getRoot().getLeft().getRight().getLeft(), notNullValue());
			assertThat("null in left-right-right", treeTest.getRoot().getLeft().getRight().getRight(), equalTo(null));
		}
		// insert in left-right-right
		else if (treeTest.getRoot().getLeft().getRight().toString().compareTo(elementTest.getElement().toString()) == 1) {
			assertThat("not null in left-right-right", treeTest.getRoot().getLeft().getRight().getRight(), notNullValue());
			assertThat("null in left-right-left", treeTest.getRoot().getLeft().getRight().getLeft(), equalTo(null));
		}
		
		
		// ROOT RIGHT
		
		// insert in right-left-left
		else if (treeTest.getRoot().getRight().getLeft().toString().compareTo(elementTest.getElement().toString()) == -1) {
			assertThat("not null in right-left-left", treeTest.getRoot().getRight().getLeft().getLeft(), notNullValue());
			assertThat("null in right-left-right", treeTest.getRoot().getRight().getLeft().getRight(), equalTo(null));
		}		
		// insert in right-left-right
		else if (treeTest.getRoot().getRight().getLeft().toString().compareTo(elementTest.getElement().toString()) == 1) {
			assertThat("not null in right-left-right", treeTest.getRoot().getRight().getLeft().getRight(), notNullValue());
			assertThat("null in right-left-left", treeTest.getRoot().getRight().getLeft().getLeft(), equalTo(null));
		}	
		// insert in right-right
		else {
			assertThat("not null in right-right", treeTest.getRoot().getRight().getRight(), notNullValue());
			assertThat("RED in right-right", treeTest.getRoot().getRight().getRight().getColor(), equalTo(Color.RED));
		}
	
	}

	
	
	
	
	
}

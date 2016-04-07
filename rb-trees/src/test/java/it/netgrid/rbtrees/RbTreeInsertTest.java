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
		RbTreeGenerator.writeDotFile(treeTest);
		assertThat("one element", treeTest.getRoot(), notNullValue());
		assertThat("null left", treeTest.getRoot().getLeft(), equalTo(null));
		assertThat("null right", treeTest.getRoot().getRight(), equalTo(null));
		
	}
	
	
	// inserimento di un oggetto nullo in un albero
	@Test 
	public void testInsertNull() {
		RbTree<String> treeTest = RbTreeGenerator.one();		
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>(null); 	
		treeTest.insert(elementTest);
		RbTreeGenerator.writeDotFile(treeTest);
	}
	

	// inserimento di un nodo in un albero composto da un solo elemento
	@Test
	public void testInsertOne() {		
		RbTree<String> treeTest = RbTreeGenerator.one();		
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>(this.fairy.textProducer().latinSentence()); 
		treeTest.insert(elementTest);
		RbTreeGenerator.writeDotFile(treeTest);
		
		// ROOT LEFT
		if (treeTest.getRoot().toString().compareTo(elementTest.getElement().toString()) == -1) {
			assertThat("element appended in left", treeTest.getRoot().getLeft(), notNullValue());
			assertThat("element appended is RED", treeTest.getRoot().getLeft().getColor(), equalTo(Color.RED));
			assertThat("element absent in right", treeTest.getRoot().getRight(), equalTo(null));
			
		}
		
		// ROOT RIGHT
		else {
			assertThat("element appended in right", treeTest.getRoot().getRight(), notNullValue());
			assertThat("element appended is RED", treeTest.getRoot().getRight().getColor(), equalTo(Color.RED));
			assertThat("element absent in left", treeTest.getRoot().getLeft(), equalTo(null));
			
		}
		
	}
		
	
	// inserimento di un nodo in un albero composto da 6 elementi
	@Test
	public void testInsertSix() {
		RbTree<String> treeTest = RbTreeGenerator.six();		
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>(this.fairy.textProducer().latinSentence()); 
		treeTest.insert(elementTest);
		RbTreeGenerator.writeDotFile(treeTest);
		assertThat("not null in right-right", treeTest.getRoot().getRight().getRight(), notNullValue());
		assertThat("RED in right-right", treeTest.getRoot().getRight().getRight().getColor(), equalTo(Color.RED));

	}

}

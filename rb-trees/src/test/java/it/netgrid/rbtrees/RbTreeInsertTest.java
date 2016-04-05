package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import io.codearte.jfairy.Fairy;

public class RbTreeInsertTest {

	private RbTree<BasicRbTreeDecorator<Object>> classUnderTest;
	private Fairy fairy;
	
	@Before
	public void init() {
		this.classUnderTest = new RbTree<BasicRbTreeDecorator<Object>>();
	}
	
	@Test
	public void testInsertEmpty() {		
		// albero vuoto
		RbTree<String> treeTest = RbTreeGenerator.empty();
		
		// elemento da inserire
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>("test");
		treeTest.insert(elementTest);
		assertThat("one element (root)", treeTest.getRoot(), notNullValue());
	}
	
	
	@Test
	public void testInsertOne() {		
		// albero con un elemento
		RbTree<String> treeTest = RbTreeGenerator.one();
		
		// elemento da inserire
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>("test");
		String eTest = elementTest.toString();
		treeTest.insert(elementTest);
		
		// dipende dall' albero generato casulamente
		if (treeTest.getRoot().toString().compareTo(elementTest.getElement().toString()) == -1) {
			assertThat("element appended", treeTest.getRoot().getLeft(), notNullValue());
		}
		else {
			assertThat("element appended", treeTest.getRoot().getRight(), notNullValue());
		}
		

	}
	
	@Test
	public void testInsertSix() {
		// albero con 6 elementi
		RbTree<String> treeTest = RbTreeGenerator.six();
		
		// elemento da inserire
		BasicRbTreeDecorator<String> elementTest = new BasicRbTreeDecorator<String>(RandomStringUtils.randomAlphabetic(10));
		treeTest.insert(elementTest);
		
		//--RAMO SINISTRO
		
		//sx sx sx
		if (treeTest.getRoot().getLeft().getLeft().toString().compareTo(elementTest.getElement().toString()) == -1) {
			assertThat("not null sx sx sx", treeTest.getRoot().getLeft().getLeft().getLeft(), notNullValue());
		}
		
		//sx sx dx
		else if (treeTest.getRoot().getLeft().getLeft().toString().compareTo(elementTest.getElement().toString()) == 1) {
			assertThat("not null sx sx dx", treeTest.getRoot().getLeft().getLeft().getRight(), notNullValue());
		}
		
		//sx dx sx
		else if (treeTest.getRoot().getLeft().getRight().toString().compareTo(elementTest.getElement().toString()) == -1) {
			assertThat("not null sx dx sx", treeTest.getRoot().getLeft().getRight().getLeft(), notNullValue());
		}
		
		//sx dx dx
		else if (treeTest.getRoot().getLeft().getRight().toString().compareTo(elementTest.getElement().toString()) == 1) {
			assertThat("not null sx dx dx", treeTest.getRoot().getLeft().getRight().getRight(), notNullValue());
		}
			
		
		//--RAMO DESTRO
		
		//dx sx sx
		if (treeTest.getRoot().getRight().getLeft().toString().compareTo(elementTest.getElement().toString()) == -1) {
			assertThat("not null dx sx sx", treeTest.getRoot().getRight().getLeft().getLeft(), notNullValue());
		}
		
		//dx sx dx
		else if (treeTest.getRoot().getRight().getLeft().toString().compareTo(elementTest.getElement().toString()) == 1) {
			assertThat("not null dx sx dx", treeTest.getRoot().getRight().getLeft().getRight(), notNullValue());
		}
		
		//dx dx 
		else {
			assertThat("not null dx dx", treeTest.getRoot().getRight().getRight(), notNullValue());
		}

		
	}

	
	
	
	
	
}

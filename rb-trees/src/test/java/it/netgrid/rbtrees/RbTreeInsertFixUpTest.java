package it.netgrid.rbtrees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import io.codearte.jfairy.Fairy;
import it.netgrid.rbtrees.RbTreeElement.Color;

/**
 * iTest.getRoot() -> Radice element -> Nodo base -> Per il calcolo di posizioni
 * di ogni nodo child -> Figlio di element
 */
public class RbTreeInsertFixUpTest {
	// private RbTree<String> classUnderTest;
	private Fairy fairy;

	@Before
	public void init() {
		// this.classUnderTest = new RbTree<String>();
		this.fairy = Fairy.create();

	}

	@Test
	public void insertFixUpEmpty() {
		RbTree<String> iTest = RbTreeGenerator.empty();
		BasicRbTreeDecorator<String> element = new BasicRbTreeDecorator<String>(fairy.textProducer().latinSentence());
		// this.classUnderTest.insertFixup(classUnderTest.getRoot());
		iTest.insertFixup(element);
		RbTreeGenerator.writeDotFile(iTest);
		assertThat("null or root", iTest.getRoot(), equalTo(null));

	}

	@Test
	public void insertFixUpOne() {
		RbTree<String> iTest = RbTreeGenerator.one();
		BasicRbTreeDecorator<String> element = new BasicRbTreeDecorator<String>(fairy.textProducer().latinSentence());
		// this.classUnderTest.insertFixup(classUnderTest.getRoot());
		iTest.getRoot().setColor(Color.RED);
		iTest.insertFixup(element);
		RbTreeGenerator.writeDotFile(iTest);
		assertThat("root is black", iTest.getRoot().getColor(), equalTo(Color.BLACK));

	}

	@Test
	public void insertFixUpSix() {
		RbTree<String> iTest = RbTreeGenerator.six();
		RbTreeElement<String> element = iTest.getRoot().getRight();
		String base = iTest.getRoot().getElement();

		BasicRbTreeDecorator<String> child = new BasicRbTreeDecorator<String>(base + base);
		child.setColor(Color.RED);
		child.setParent(element);
		element.setRight(child);

		element = child;
		child = new BasicRbTreeDecorator<String>(base + base + base);
		child.setColor(Color.RED);
		child.setParent(element);
		element.setRight(child);

		// this.classUnderTest.insertFixup(classUnderTest.getRoot());
		iTest.insertFixup(child);
		RbTreeGenerator.writeDotFile(iTest);
		assertThat("root is black", iTest.getRoot().getColor(), equalTo(Color.BLACK));
	}

	// Ricorda che Nodo Null == Nero (nessuna istruzione)
	@Test
	public void blackRoot() { //Radice Nera
		RbTree<String> iTest = RbTreeGenerator.six();
		RbTreeElement<String> element = iTest.getRoot().getRight();
		iTest.insertFixup(element);

		
		if (iTest.getRoot() != null) {
			assertThat("root is black", iTest.getRoot().getColor(), equalTo(Color.BLACK));
		}
	}

		// Nodo Rosso e Figli Neri
		public int nullNode(RbTreeElement<String> element){
			RbTree<String> iTest = RbTreeGenerator.six();
			element = iTest.getRoot();
			iTest.insertFixup(element);
			if (element == null) {
				counter = 1;
				return counter;
			} else if(element.isRed()){
				iTest.getRoot().getLeft().setColor(Color.BLACK);
				iTest.getRoot().getRight().setColor(Color.BLACK);
				assertThat("node is red", iTest.getRoot().getColor(), equalTo(Color.RED));
				assertThat("child left is black", iTest.getRoot().getLeft().getColor(), equalTo(Color.BLACK));
				assertThat("child right is black", iTest.getRoot().getRight().getColor(), equalTo(Color.BLACK));
				counter = 0;
				checkLeftNode(element);
			}
			return counter;		
			
		}
			public int checkLeftNode(RbTreeElement<String> element){
				RbTree<String> iTest = RbTreeGenerator.six();
				element = iTest.getRoot().getLeft();
				iTest.insertFixup(element);
				if (element == null) {
					counterL = 1;
					return counterL;
				}
				else if(element.isRed()){
				element.getLeft().setColor(Color.BLACK);
				element.getRight().setColor(Color.BLACK);
				assertThat("node is red", element.getColor(), equalTo(Color.RED));
				assertThat("child left is black", element.getLeft().getColor(), equalTo(Color.BLACK));
				assertThat("child right is black", element.getRight().getColor(), equalTo(Color.BLACK));
				counterL = 0;
				checkRightNode(element);
			}
			return counterL;}
			
			public int checkRightNode(RbTreeElement<String> element){
				RbTree<String> iTest = RbTreeGenerator.six();
				element = iTest.getRoot().getRight();
				iTest.insertFixup(element);
			
				if (element == null) {
					counterR = 1;
					return counterR;
				}
				else{
					if(element.isRed()){
						element.getLeft().setColor(Color.BLACK);
						assertThat("node is red", element.getColor(), equalTo(Color.RED));
						assertThat("child left is black", element.getLeft().getColor(), equalTo(Color.BLACK));
						counterR = 0;
						checkAll(element);
						
				}
					return counterR;
			}
			
		}
			public int checkAll(RbTreeElement<String> element) {
				int fCounter;

				fCounter = counter + counterL + counterR;
				
				return nullNode(element) + checkLeftNode(element) + checkRightNode(element) + fCounter;

			}
	
			
		
	

	// Ogni Radice ha lo stesso numero di Nodi Neri

	int counter;
	int counterL;
	int counterR;
	RbTree<String> iTest = RbTreeGenerator.six();
	
	public int visita(RbTreeElement<String> element) {
		
		element = iTest.getRoot();
		iTest.insertFixup(element);

		if (element == null) {
			counter = 1;
			return counter;
		} else {
			counter = 0;
			visitaLeft(element);
			return counter;
		}

	}

	public int visitaLeft(RbTreeElement<String> element) {
		element = iTest.getRoot().getLeft();
		if (element == null) {
			counterL = 1;
			return counterL;
		} else {
			counterL = 0;
			visitaRight(element);
			return counterL;
		}
	}

	public int visitaRight(RbTreeElement<String> element) {
		element = iTest.getRoot().getRight();
		if (element == null) {
			counterR = 1;
			return counterR;
		} else {

			
			counterR = 0;
			visitaCheck(element);
			return counterR;

		}

	}

	public int visitaCheck(RbTreeElement<String> element) {
		int fCounter;

		fCounter = counter + counterL + counterR;
		assertThat("same number of black nodes in root", visitaLeft(element), equalTo(visitaRight(element)));
		return visita(element) + visitaLeft(element) + visitaRight(element) + fCounter;

	}
}

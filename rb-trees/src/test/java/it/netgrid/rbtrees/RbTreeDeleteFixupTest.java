package it.netgrid.rbtrees;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import io.codearte.jfairy.Fairy;
import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTreeDeleteFixupTest {
	RbTree<String> classunderTest;
	private Fairy fairy;
	
	@Before
	public void init(){
		this.classunderTest= new RbTree<String>();
		this.fairy = Fairy.create();
	}
	
	@Test
	public void testNull() {
		 classunderTest = RbTreeGenerator.empty();
		this.classunderTest.deleteFixup(classunderTest.getRoot());
		//assertThat("null equals null", result, equalTo(0));
		assertThat("null root", classunderTest.getRoot(), equalTo(null));
<<<<<<< HEAD
		RbTreeGenerator.writeDotFile(classunderTest);
=======
>>>>>>> dca32b3fc982c0b80c77e604dfee2c2c9cc0fa43
	}
	
	@Test
	public void testOne() {
		classunderTest = RbTreeGenerator.one();
		this.classunderTest.deleteFixup(classunderTest.getRoot());
		assertThat("root is black", classunderTest.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("null left", classunderTest.getRoot().getLeft(), equalTo(null));
		assertThat("null right", classunderTest.getRoot().getRight(), equalTo(null));
<<<<<<< HEAD
		RbTreeGenerator.writeDotFile(classunderTest);
=======
		
>>>>>>> dca32b3fc982c0b80c77e604dfee2c2c9cc0fa43
	}

	@Test
	public void testSix() {
		classunderTest = RbTreeGenerator.six();
<<<<<<< HEAD
		this.classunderTest.deleteFixup(classunderTest.getRoot().getLeft().getLeft());
=======
		this.classunderTest.deleteFixup(classunderTest.getRoot());
>>>>>>> dca32b3fc982c0b80c77e604dfee2c2c9cc0fa43
		assertThat("root is black", classunderTest.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("not null left", classunderTest.getRoot().getLeft(), notNullValue());
		assertThat("not null right", classunderTest.getRoot().getRight(), notNullValue());
		assertThat("not equal", classunderTest.getRoot().getLeft(), not(equals(classunderTest.getRoot().getRight())));	
<<<<<<< HEAD
		RbTreeGenerator.writeDotFile(classunderTest);
	}
	@Test
	public void testSpec() {
		classunderTest = RbTreeGenerator.six();
		//RbTreeElement<String> left= parent.getLeft();
		//this.classunderTest.deleteFixup(classunderTest.getRoot().getLeft().getRight());
		this.classunderTest.deleteFixup(classunderTest.getRoot().getLeft().getLeft());
		assertThat("root is black", classunderTest.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("null left", classunderTest.getRoot().getLeft(), equalTo(null));
		assertThat("null right", classunderTest.getRoot().getRight(), equalTo(null));
		RbTreeGenerator.writeDotFile(classunderTest);
	}

	public int Visita(RbTreeElement<String> element) {
		int count, countLeft, countRight;

		if (element == null) {
			count = 1;
			return count;

		} else {
			count = element.isBlack() ? 1 : 0;
			countRight = Visita(element.getRight());
			countLeft = Visita(element.getLeft());
			return count;
		}

	}

	public void Test(RbTreeElement<String> element) {

		if (element == null) {
			return;
		}
		if (element.isRed()) {
			boolean leftCheck = element.getLeft() == null ? true : element.getLeft().isBlack();
			boolean RightCheck = element.getRight() == null ? true : element.getLeft().isBlack();

		}

	}

=======
	}
	
	@Test
	public void testSpec() {
		classunderTest = RbTreeGenerator.six();
		//RbTreeElement<String> left= parent.getLeft();
		//this.classunderTest.deleteFixup(classunderTest.getRoot());
		this.classunderTest.deleteFixup(classunderTest.getRoot().getLeft().getLeft());
		assertThat("root is black", classunderTest.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("null left", classunderTest.getRoot().getLeft(), notNullValue());
		assertThat("null right", classunderTest.getRoot().getRight(), notNullValue());
		
	}
	
>>>>>>> dca32b3fc982c0b80c77e604dfee2c2c9cc0fa43
}
		
	
  



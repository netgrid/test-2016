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
		RbTreeGenerator.writeDotFile(classunderTest);
	}
	
	@Test
	public void testOne() {
		classunderTest = RbTreeGenerator.one();
		this.classunderTest.deleteFixup(classunderTest.getRoot());
		assertThat("root is black", classunderTest.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("null left", classunderTest.getRoot().getLeft(), equalTo(null));
		assertThat("null right", classunderTest.getRoot().getRight(), equalTo(null));
		RbTreeGenerator.writeDotFile(classunderTest);
	}

	@Test
	public void testSix() {
		classunderTest = RbTreeGenerator.six();
		this.classunderTest.deleteFixup(classunderTest.getRoot().getLeft().getLeft());
		assertThat("root is black", classunderTest.getRoot().getColor(), equalTo(Color.BLACK));
		assertThat("not null left", classunderTest.getRoot().getLeft(), notNullValue());
		assertThat("not null right", classunderTest.getRoot().getRight(), notNullValue());
		assertThat("not equal", classunderTest.getRoot().getLeft(), not(equals(classunderTest.getRoot().getRight())));	
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
	public int Visita(RbTree<String> x){
		if(x==null){
			return 1;
		}
		
		
		
		return x;
		
	}
	public void Test(RbTree<String> Tree){
	if(Tree.getRoot()==null){
		
		if(Tree.getRoot().isRed()){
					Tree.getRoot().setColor(Color.BLACK);
				}
			if(Tree.getRoot().getLeft().getLeft()!=null&&
			   Tree.getRoot().getLeft().getRight()!=null&&
			   Tree.getRoot().getRight().getLeft()!=null){
						
					if(Tree.getRoot().getLeft().isRed()){
						Tree.getRoot().getLeft().getLeft().setColor(Color.BLACK);
						Tree.getRoot().getLeft().getRight().setColor(Color.BLACK);
					}
					if(Tree.getRoot().getRight().isRed()){
						Tree.getRoot().getRight().getLeft().setColor(Color.BLACK);
					}
		
		}			
			
		}
	}
		
	}
  



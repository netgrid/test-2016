package it.netgrid.rbtrees;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import io.codearte.jfairy.Fairy;
import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTreeGenerator {

	private static final String DOT_FILE_PREPEND = "digraph graphname {";
	private static final String DOT_FILE_APPEND = "}";
	private static int writesCount = 0;
	
	private static Fairy fairy = Fairy.create();
	
	public static boolean writeDotFile(RbTree<?> tree) {
		StringBuffer contents = new StringBuffer();
		StringBuffer declarations = new StringBuffer();
		
		if(tree.getRoot() != null) {
			writeSubTree(tree.getRoot(), contents, declarations);
		}
		
		try {
			BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(getDotFileName())));
	        
	        //write contents of StringBuffer to a file
	        bwr.write(DOT_FILE_PREPEND + declarations.toString() + contents.toString() + DOT_FILE_APPEND);
	       
	        //flush the stream
	        bwr.flush();
	       
	        //close the stream
	        bwr.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	private static String getDotFileName() {
		return String.format("rb-tree-%d.gv", writesCount++);
	}
	
	private static void writeSubTree(RbTreeElement<?> element, StringBuffer content, StringBuffer declarations) {
		int id = java.lang.System.identityHashCode(element.getElement());
		String declaration = String.format("%d[color=%s];", id, element.getColor().name());
		declarations.append(declaration);
		
		if(element.getLeft() != null) {
			int childId = java.lang.System.identityHashCode(element.getLeft().getElement());
			content.append(String.format("%d -> %d[label=\" L\"];", id, childId));
			writeSubTree(element.getLeft(), content, declarations);
		}	
		
		if(element.getRight() != null) {
			int childId = java.lang.System.identityHashCode(element.getRight().getElement());
			content.append(String.format("%d -> %d[label=\" R\"];", id, childId));
			writeSubTree(element.getRight(), content, declarations);
		}
	}
	
	public static RbTree<String> empty() {
		return new RbTree<String>();
	}
	
	public static RbTree<String> one() {
		RbTree<String> retval = new RbTree<String>();
		BasicRbTreeDecorator<String> element = new BasicRbTreeDecorator<String>(fairy.textProducer().latinSentence());
		element.setColor(Color.BLACK);
		retval.setRoot(element);
		return retval;
	}
	
	public static RbTree<String> six() {
		String base = fairy.textProducer().latinSentence();
		RbTree<String> retval = new RbTree<String>();
		RbTreeElement<String> element = new BasicRbTreeDecorator<String>(multi(base, 4));
		retval.setRoot(element);
		element.setColor(Color.BLACK);
		
		// root child left
		BasicRbTreeDecorator<String> child = new BasicRbTreeDecorator<String>(multi(base, 2));
		child.setColor(Color.BLACK);
		child.setParent(element);
		element.setLeft(child);
		
		// root child right
		child = new BasicRbTreeDecorator<String>(multi(base, 6));
		child.setColor(Color.BLACK);
		child.setParent(element);
		element.setRight(child);
		
		// root left child left
		element = retval.getRoot().getLeft();
		child = new BasicRbTreeDecorator<String>(multi(base, 1));
		child.setColor(Color.RED);
		child.setParent(element);
		element.setLeft(child);
		
		// root left child right
		element = retval.getRoot().getLeft();
		child = new BasicRbTreeDecorator<String>(multi(base, 3));
		child.setColor(Color.RED);
		child.setParent(element);
		element.setRight(child);
		
		// root right child left
		element = retval.getRoot().getRight();
		child = new BasicRbTreeDecorator<String>(multi(base, 5));
		child.setColor(Color.RED);
		child.setParent(element);
		element.setLeft(child);
		
		return retval;
	}
	
	private static String multi(String base, int multi) {
		String retval = "";
		for(int i=0; i<multi; i++) {
			retval += base;
		}
		
		return retval;
	}
}

package it.netgrid.rbtrees;

import io.codearte.jfairy.Fairy;
import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTreeGenerator {

	private static Fairy fairy = Fairy.create();
	
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

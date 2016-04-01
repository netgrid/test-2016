package it.netgrid.rbtrees;

import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTree<T extends Comparable<String>> {

	private RbTreeElement<T> root;

	private void leftRotate(RbTreeElement<T> element) {
	}

	private void rightRotate(RbTreeElement<T> element) {
	}

	private void insertFixup(RbTreeElement<T> element) {
		while (element.isRed()){
		    do
		    	if(element.getParent(z)==left(element.getParent(element.getParent(z)))){
		    		y = right(element.getParent(element.getParent(z)));
		    		
		    	}if(color.isRed(y)){
		    		color(element.getParent(z))= Color.BLACK; 
		    		color(y) = Color.BLACK;
		    		color(element.getParent(element.getParent(z)))= Color.RED;
		    		z = element.getParent(element.getParent(z));
		    	}
		    	else if(z =element.getRight(element.getParent(z))){
		    		z = element.getParent(z);
		    		leftRotate(); 
		    		color(element.getParent(z)) = Color.BLACK;
		    		color(element.getParent(element.getParent(z))) = Color.RED;
		    		rightRotate(element, element.getParent(element.getParent(z)));
		    		
		    	}
		    	else{
		    		z = element.getParent(z);
		    		rightRotate(element, element.getParent(element.getParent(z))); 
		    		color(element.getParent(z)) = Color.BLACK;
		    		color(element.getParent(element.getParent(z))) = Color.RED;
		    		leftRotate();
		    		
		    	}
		}
		color(root(element)) = Color.BLACK;
	}

	private void deleteFixup(RbTreeElement<T> element) {
	}

	public void insert(T element) {
	}

	public void delete(T element) {
	}

	public T get(String element) {
		return null;
	}

	public RbTreeElement<T> getRoot() {
		return root;
	}

	private void setRoot(RbTreeElement<T> root) {
		this.root = root;
	}
}

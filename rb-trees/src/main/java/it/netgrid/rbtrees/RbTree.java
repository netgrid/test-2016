package it.netgrid.rbtrees;

import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTree<T extends Comparable<String>> {

	private RbTreeElement<T> root;

	private void leftRotate(RbTreeElement<T> element) {
	}

	private void rightRotate(RbTreeElement<T> element) {
	}

	private void insertFixup(RbTreeElement<T> element) {
		while (element.getParent().isRed()){
		    do{
		    	if(element.getParent().getParent().isRed()){
		    		setParent(element).setColor(Color.BLACK);
		    		element.getParent().getParent().setColor(Color.BLACK);
		    		element.getParent().getParent().getParent().setColor(Color.RED);
		    		element = element.getParent().getParent().getParent();
		    		
		    	} else{
		    		if(element.getRight() && element.getParent().getLeft()){
		    			leftRotate(element.getParent());
		    			element = element.getLeft();
		    		}else if(element.getRight() && element.getParent().getRight()){
		    			rightRotate(element.getParent());
		    			element = element.getRight();
		    		}
		    		setParent(element).setColor(Color.BLACK);
		    		setParent(element).setParent(element).setParent(element).setColor(Color.RED);
		    		if(element.getLeft()){
		    			rightRotate(element.getParent().getParent().getParent());
		    		}else{
		    			leftRotate(element.getParent().getParent().getParent());
		    		}
		    	}
		    } while(true);
		    		
		    		/**y = right(element.getParent(element.getParent(z)));
		    		
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
		    		
		    	}*/
		}
		    		
		root.setColor(Color.BLACK);
	}

	private RbTreeElement<T> setParent(RbTreeElement<T> element) {
		// TODO Auto-generated method stub
		return null;
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

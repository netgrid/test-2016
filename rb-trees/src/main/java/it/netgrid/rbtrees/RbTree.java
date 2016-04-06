package it.netgrid.rbtrees;

import java.util.List;

import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTree<T extends Comparable<String>> {

	private RbTreeElement<T> root;

	public void leftRotate(RbTreeElement<T> element) {
	}

	public void rightRotate(RbTreeElement<T> element) {
	}

	public void insertFixup(RbTreeElement<T> element) {
		
	}

	public void deleteFixup(RbTreeElement<T> element) {
	}

	public void insert(RbTreeElement<T> element) {
		RbTreeElement<T> y = null;
		RbTreeElement<T> x = this.getRoot();
		while (x != null) {
			y = x;
			if (element.getElement().toString().compareTo(x.getElement().toString()) == -1) {
				x = x.getLeft();
			}
			else {
				x = x.getRight();
			}
		}
			
		element.setParent(y);
		if (y == null) {
			this.setRoot(element);
		}
		else if (element.getElement().toString().compareTo(y.getElement().toString()) == -1) {
			y.setLeft(element);
		}
		else {
			y.setRight(element);
		}
			
		element.setLeft(null);
		element.setRight(null);
		element.setColor(Color.RED);
			
	}


	public void delete(T element) {
	}

	public T get(String element) {
		return null;
	}

	public RbTreeElement<T> getRoot() {
		return root;
	}

	public void setRoot(RbTreeElement<T> root) {
		this.root = root;
	}
	
	public List<T> getList(String element) {
		return null;
	}
}

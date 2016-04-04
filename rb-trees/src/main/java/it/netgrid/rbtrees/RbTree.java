package it.netgrid.rbtrees;

import java.util.List;

import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTree<T extends Comparable<String>> {

	private RbTreeElement<T> root;

	private void leftRotate(RbTreeElement<T> element) {
	}

	private void rightRotate(RbTreeElement<T> element) {
	}

	private void insertFixup(RbTreeElement<T> element) {
		
	}

	private void deleteFixup(RbTreeElement<T> element) {
	}

	public void insert(RbTreeElement<T> element) {
		RbTreeElement<T> y = null;
		RbTreeElement<T> x = this.getRoot();
		
		while (!x.equals(null)) {
			y = x;
			if (element.getElement().toString().compareTo(x.getElement().toString()) < 0) {
				x = x.getLeft();
			}
			else {
				x = x.getRight();
			}
		}
		element.setParent(y);
		if (!y.equals(null)) {
			this.setRoot(element);
		}
		else if (element.getElement().toString().compareTo(y.getElement().toString()) < 0) {
			y.setLeft(element);
		}
		else {
			y.setRight(element);
		}
		
		element.setLeft(null);
		element.setRight(null);
		element.setColor(Color.RED);
		
		// insertFixup(RbTreeElement<T> element);
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
	
	public List<T> getList(String element) {
		return null;
	}
}

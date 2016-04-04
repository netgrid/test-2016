package it.netgrid.rbtrees;

import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTree<T extends Comparable<String>> {

	private RbTreeElement<T> root;

	private void leftRotate(RbTreeElement<T> element) {
	}

	private void rightRotate(RbTreeElement<T> element) {
	}

	private void insertFixup(RbTreeElement<T> element) {
		RbTreeElement<T> y = null;
		while (element.getParent().isRed()) {
			if (element.getParent() == element.getParent().getParent().getLeft()) {
				y = element.getParent().getParent().getRight();

				if (y.isRed()) {
					element.getParent().setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					element.getParent().getParent().setColor(Color.RED);
					element = element.getParent().getParent();

				} else if (element == element.getParent().getRight()) {
					element = element.getParent();
					leftRotate(element);
				} else {
					element.getParent().setColor(Color.BLACK);
					element.getParent().getParent().setColor(Color.RED);
					rightRotate(element.getParent().getParent());

				}
			} else {
				y = element.getParent().getParent().getLeft();
			}
			if (y.isRed()) {
				element.getParent().setColor(Color.BLACK);
				y.setColor(Color.BLACK);
				element.getParent().getParent().setColor(Color.RED);
				element = element.getParent().getParent();

			} else if (element == element.getParent().getLeft()) {
				element = element.getParent();
				rightRotate(element);
			} else {
				element.getParent().setColor(Color.BLACK);
				element.getParent().getParent().setColor(Color.RED);
				leftRotate(element.getParent().getParent());
			}
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

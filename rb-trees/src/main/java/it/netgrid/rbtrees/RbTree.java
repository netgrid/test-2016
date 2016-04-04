package it.netgrid.rbtrees;

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

		RbTreeElement<T> w;

		while (element != root && element.isBlack() == true) {

			if (element == element.getParent().getLeft()) {
				w = element.getParent().getRight();
				if (w.isRed()) {
					w.setColor(Color.BLACK);
					element.getParent().setColor(Color.RED);
					leftRotate(element.getParent());
					w = element.getParent().getRight();
				}

				if (w.getLeft().isBlack() && w.getRight().isBlack()) {
					w.setColor(Color.RED);
					element = element.getParent();
				}

				else {
					if (w.getRight().isBlack()) {
						w.getLeft().setColor(Color.BLACK);
						w.setColor(Color.RED);
						rightRotate(w);
						w = element.getParent().getRight();
					}
					w.setColor(element.getParent().getColor());
					element.getParent().setColor(Color.BLACK);
					w.getRight().setColor(Color.BLACK);
					leftRotate(element.getParent());
					element = root;

				}

			} else {
				w = element.getParent().getLeft();
				if (w.isRed()) {
					w.setColor(Color.BLACK);
					element.getParent().setColor(Color.RED);
					rightRotate(element.getParent());
					w = element.getParent().getLeft();
				}

				if (w.getRight().isBlack() && w.getLeft().isBlack()) {
					w.setColor(Color.RED);
					element = element.getParent();
				}

				else {
					if (w.getLeft().isBlack()) {
						w.getRight().setColor(Color.BLACK);
						w.setColor(Color.RED);
						leftRotate(w);
						w = element.getParent().getLeft();
					}
					w.setColor(element.getParent().getColor());
					element.getParent().setColor(Color.BLACK);
					w.getLeft().setColor(Color.BLACK);
					rightRotate(element.getParent());
					element = root;

				}

			}

		}

		element.setColor(Color.BLACK);
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

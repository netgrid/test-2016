package it.netgrid.rbtrees;

import java.util.List;

import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTree<T extends Comparable<String>> {

	private RbTreeElement<T> root;

	public void leftRotate(RbTreeElement<T> element) {
	}

	public void rightRotate(RbTreeElement<T> element) {
	}

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 25611c1916f221a442676d23b32b0795190cd27a
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
<<<<<<< HEAD

	public void deleteFixup(RbTreeElement<T> element) {
>>>>>>> develop
	}

=======
>>>>>>> 25611c1916f221a442676d23b32b0795190cd27a
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

	public void setRoot(RbTreeElement<T> root) {
		this.root = root;
	}
	
	public List<T> getList(String element) {
		return null;
	}
}

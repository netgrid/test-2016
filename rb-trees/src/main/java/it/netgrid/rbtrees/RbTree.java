package it.netgrid.rbtrees;

import java.util.List;

import it.netgrid.rbtrees.RbTreeElement.Color;

public class RbTree<T extends Comparable<String>> {

	private RbTreeElement<T> root;

	public void leftRotate(RbTreeElement<T> element) {
	}

	
	private void rightRotate(RbTreeElement<T> element) {
		RbTreeElement<T> y = element.getLeft();						//Imposto y
		element.setLeft(y.getRight());								//Sposto il sottoalbero destro di x nel sottoalbero 
		if(y.getRight() != null){									//sinistro sinistro di x
			y.getRight().setParent(element);
		}
		y.setParent(element.getParent());							// collego il padre di x con quello di y
		if(element.getParent() == null){
			root = y;
		}
		else{
			if(element == element.getParent().getRight()){
				element.getParent().setRight(y);
			}
			else{
				element.getParent().setLeft(y);
			}
		}
		y.setRight(element);										//Pone x a destra di y 
		element.setParent(y);
	}


	public void insertFixup(RbTreeElement<T> element) {
		RbTreeElement<T> y = null;
		while (element != null && element.getParent() != null && element.getParent().isRed()) {
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
		if (root != null) {
			root.setColor(Color.BLACK);
		}
	}

	public RbTreeElement<T> setParent(RbTreeElement<T> element) {

		return null;
	}

	public void deleteFixup(RbTreeElement<T> element) {

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

			if(element!=null){
				element.setColor(Color.BLACK);
			}

		if (element != null) {
			element.setColor(Color.BLACK);
		}

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

	public void setRoot(RbTreeElement<T> root) {
		this.root = root;
	}

	public List<T> getList(String element) {
		return null;
	}

	public int compareTo(String o) {
		if (this.root == null) {
			if (o == null) {
				return 0;
			}

			return -1;
		}

		return this.root.toString().compareTo(o);
	}

}

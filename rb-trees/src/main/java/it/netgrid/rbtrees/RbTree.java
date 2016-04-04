package it.netgrid.rbtrees;

import java.util.List;

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

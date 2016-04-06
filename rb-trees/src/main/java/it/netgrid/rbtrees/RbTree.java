package it.netgrid.rbtrees;

import java.util.List;

public class RbTree<T extends Comparable<String>> {
	
	private RbTreeElement<T> root;
	private int thresold = 0;

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
		RbTreeElement<T> x = this.root;
		while(thresold==0){
			if(x.compareTo(element)<0){
				x = x.getParent().getRight();
				thresold = -1;
			}else{
				if(x.compareTo(element)>0){
					x = x.getParent().getLeft();
					thresold = 1;
				}else{
					thresold = 0;
				}
			}
		}
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

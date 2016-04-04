package it.netgrid.rbtrees;

public class RbTree<T extends Comparable<String>> {

	private RbTreeElement<T> root;
	
	private void leftRotate(RbTreeElement<T> element) {
		RbTreeElement<T> y;
		RbTreeElement<T> x;
		RbTreeElement<T> z;// x parent
		y=element.getRight();
		x=element.getRight();
		x=y.getLeft();
		
		if(x!= null){
			x=y.getParent().getLeft();
			x.getParent();
			z=x.getParent();
			z=y.getParent();
			if(z==null){
				y=root;
				
			}else{
				
					
				}
			}
		}
		
	

	private void rightRotate(RbTreeElement<T> element) {
	}

	private void insertFixup(RbTreeElement<T> element) {
		
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

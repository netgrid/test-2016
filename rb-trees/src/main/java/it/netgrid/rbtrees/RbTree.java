package it.netgrid.rbtrees;

public class RbTree<T extends Comparable<String>> {

	private RbTreeElement<T> root;

	
	public void leftRotate(RbTreeElement<T> element) {
		RbTreeElement<T> y;
		y=element.getRight();
		element.setRight(y.getLeft());
		if(y.getLeft()!= null){
			y.getParent().getLeft().setLeft(element);
		}
		y.setParent(element.getParent());
		
		if(element.getParent()==null){
			y=root;
			
		}else{
			if(element==element.getParent().getLeft()){
				element.getParent().setLeft(y);
			}else {
				element.getParent().setRight(y);
			}
		}
			y.setLeft(element);
			element.setParent(y);
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

	void setRoot(RbTreeElement<T> root) {
		this.root = root;
	}
}

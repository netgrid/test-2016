package it.netgrid.rbtrees;

import java.util.List;

public class RbTree<T extends Comparable<String>> {

	private RbTreeElement<T> root;

	
	public void leftRotate(RbTreeElement<T> element) {
		RbTreeElement<T> y;
		RbTreeElement<T> x;
		RbTreeElement<T> z;// x parent
		y=element.getRight(); 
		x=element.getRight(); 
		x=y.getLeft(); // sposto il sottoalbero sinistro di y nel sottoalbero di destro di x
		
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

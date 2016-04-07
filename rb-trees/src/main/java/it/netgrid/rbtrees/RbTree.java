package it.netgrid.rbtrees;

import java.awt.Color;
import java.util.List;

public class RbTree<T extends Comparable<String>> {

	private RbTreeElement<T> root;

	
	//procedura che restituisce  un puntatore all'elemeneto minimo del sottoalbero con radice in un nodo x
	private RbTreeElement<T> treeMinimum(RbTreeElement<T> element){
		RbTreeElement<T> result=null;
		while(!(element.getLeft().equals(null))){
			result=element.getLeft();
		}
		return result;
	}
	
	//procedura che restituisce  un puntatore all'elemeneto massimo del sottoalbero con radice in un nodo x
	private RbTreeElement<T> treeMaximum(RbTreeElement<T> element){
		RbTreeElement<T> result=null;
		while(!(element.getRight().equals(null))){
			result=element.getRight();
		}
		return result;
	}



	public void leftRotate(RbTreeElement<T> element) {
		RbTreeElement<T> y = element.getRight();					//Imposto y
		if(y.getLeft() != null){
			element.setRight(y.getLeft());							//Sposto il sottoalbero destro di x nel sottoalbero 
		}
		if(y.getLeft() != null){									//sinistro sinistro di x
			y.getLeft().setParent(element);
		}
		y.setParent(element.getParent());							// collego il padre di x con quello di y
		if(element.getParent() == null){
			root = y;
		}
		else{
			if(element == element.getParent().getLeft()){
				element.getParent().setLeft(y);
			}
			else{
				element.getParent().setRight(y);
			}
		}
		y.setLeft(element);										//Pone x a destra di y 
		element.setParent(y);
		}

		

	

	public void rightRotate(RbTreeElement<T> element) {
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

	public RbTreeElement<T> treeSuccessor(RbTreeElement<T> element){
		RbTreeElement<T> result;
		if(element.getRight().equals(null)){
			return treeMinimum(element.getRight());
		}
		result=element.getParent();
		while((!(result.equals(null)))&&(element.equals(result.getRight()))){
			element=result;
			result=result.getParent();
		}
		return result;
	}
	
	//funzione che elemina un nodo dall'albero
	public RbTreeElement<T> delete(RbTreeElement<T> elementZ) {
		RbTreeElement<T> result;
		RbTreeElement<T> elementX;
		
		//1-6----------------------------------------------------------------------------------------------|
		if((elementZ.getLeft().equals(null))&&(elementZ.getRight().equals(null))){
			result= elementZ;	
		}
		else{
			result=treeSuccessor(elementZ);
		}
		if(!(result.getLeft().equals(null))){
			elementX=result.getLeft();
		}
		else{
			elementX=result.getRight();
		}
		
		//7------------------------------------------------------------------------------------------------|
		elementX.setParent(result.getParent());
		
		//8-12---------------------------------------------------------------------------------------------|
		if(result.getParent().equals(null)){
			this.setRoot(elementX);
		}
		else if (result.equals(result.getParent().getLeft())) {
			result.getParent().setLeft(elementX);
		}
		else {
			result.getParent().setRight(elementX);
		}
		
		//13-15--------------------------------------------------------------------------------------------|
		if(!(result.equals(elementZ))){
			//copia dati satellite
			elementZ.setColor(result.getColor());
			elementZ.setLeft(result.getRight());
			elementZ.setRight(result.getRight());
			elementZ.setParent(result.getParent());
		}
		
		//16-17--------------------------------------------------------------------------------------------|
		if(result.getColor().equals(Color.BLACK)){
			deleteFixup(elementX);
		}
		
		//18-----------------------------------------------------------------------------------------------|
		return result;
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

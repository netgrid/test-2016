package it.netgrid.rbtrees;

import java.awt.Color;
import java.util.List;

public class RbTree<T extends Comparable<String>> {

	private RbTreeElement<T> root;
	
	//procedura che restituisce  un puntatore all'elemeneto minimo del sottoalbero con radice in un nodo x
	private RbTreeElement<T> treeMinimum(RbTreeElement<T> element){
		RbTreeElement<T> result=null;
		while(!(element.getLeft()==null)){
			result=element.getLeft();
		}
		return result;
	}
	
	//procedura che restituisce  un puntatore all'elemeneto massimo del sottoalbero con radice in un nodo x
	private RbTreeElement<T> treeMaximum(RbTreeElement<T> element){
		RbTreeElement<T> result=null;
		while(!(element.getRight()==null)){
			result=element.getRight();
		}
		return result;
	}


	private void leftRotate(RbTreeElement<T> element) {
	}

	public void rightRotate(RbTreeElement<T> element) {
	}

	public void insertFixup(RbTreeElement<T> element) {
		
	}

	public void deleteFixup(RbTreeElement<T> element) {
	}

	public void insert(T element) {
	}

	public RbTreeElement<T> treeSuccessor(RbTreeElement<T> element){
		RbTreeElement<T> result;
		if(element.getRight()==null){
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
		
		
		//ritorna null se il tree è vuoto
		if(elementZ==(null)){
			return null;
		}
		//eliminazione radice senza figli
		if(elementZ == this.getRoot()){
			if((elementZ.getLeft()==null)&&(elementZ.getRight()==null)){
				return null;
			}
		}

		
		//1-6----------------------------------------------------------------------------------------------|
		if((elementZ.getLeft()==null)||(elementZ.getRight()==null)){
			result= elementZ;	
		}
		else{
			result=treeSuccessor(elementZ);
		}
		if(!(result.getLeft()==null)){
			elementX=result.getLeft();
		}
		else{
			elementX=result.getRight();
		}
		
		
		
		//7------------------------------------------------------------------------------------------------|
		if(!(elementX==null)){
		elementX.setParent(result.getParent());
		}
		//8-12---------------------------------------------------------------------------------------------|
		if(result.getParent()==null){
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
			elementZ.setElement(result.getElement());
			
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

package it.netgrid.rbtrees;

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

	private void leftRotate(RbTreeElement<T> element) {
	}

	private void rightRotate(RbTreeElement<T> element) {
	}

	private void insertFixup(RbTreeElement<T> element) {
	}

	private void deleteFixup(RbTreeElement<T> element) {
		
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
	
	public void delete(RbTreeElement<T> element) {
		RbTreeElement<T> result;
		if((element.getLeft().equals(null))&&(element.getRight().equals(null))){
			result= element;	
		}
		else{
			result=treeSuccessor(element);
		}
		if(!(result.getLeft().equals(null))){
			element=result.getLeft();
		}
		else{
			element=result.getRight();
		}
		element.setParent(result.getParent());
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

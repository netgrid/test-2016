package it.netgrid.rbtrees;

public interface RbTreeElement<T extends Comparable<String>> {

	public enum Color{BLACK,RED}
	
	public boolean isBlack();
	public boolean isRed();
	public RbTreeElement<T> getParent();
	public Color getColor();
	public RbTreeElement<T> getLeft();
	public RbTreeElement<T> getRight();
	public T getElement();
}

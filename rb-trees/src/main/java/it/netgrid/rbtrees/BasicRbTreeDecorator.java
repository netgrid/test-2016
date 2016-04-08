package it.netgrid.rbtrees;

public class BasicRbTreeDecorator<T> implements RbTreeElement<T> {

	private T element;
	private Color color;
	private RbTreeElement<T> left;
	private RbTreeElement<T> right;
	private RbTreeElement<T> parent;

	public BasicRbTreeDecorator(T element) {
		this.element = element;
	}

	public boolean isBlack() {
		return this.color == Color.BLACK;
	}

	public boolean isRed() {
		return this.color == Color.RED;
	}

	public RbTreeElement<T> getParent() {
		return this.parent;
	}

	public Color getColor() {
		return this.color;
	}

	public RbTreeElement<T> getLeft() {
		return this.left;
	}

	public RbTreeElement<T> getRight() {
		return this.right;
	}

	public void setLeft(RbTreeElement<T> left) {
		this.left = left;
	}

	public void setRight(RbTreeElement<T> right) {
		this.right = right;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public T getElement() {
		return this.element;
	}

	public int compareTo(String o) {
		if (this.element == null) {
			if (o == null) {
				return 0;
			}

			return -1;
		}

		return this.element.toString().compareTo(o);
	}

	public void setParent(RbTreeElement<T> parent) {
		this.parent = parent;
	}

	@Override
	public void setElement(T element) {
		this.element = element;
	}

}

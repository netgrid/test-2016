package it.netgrid.rbtrees;

import org.junit.Before;


import io.codearte.jfairy.Fairy;
import it.netgrid.rbtrees.RbTreeElement.Color;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class DeleteFixUp {
	private RbTree<BasicRbTreeDecorator<Object>> classUnderTest;
	private Fairy fairy;
	private RbTreeElement<BasicRbTreeDecorator<Object>> root;
	
	@Before
	public void init() {
		this.classUnderTest = new RbTree<BasicRbTreeDecorator<Object>>();
		this.fairy = Fairy.create();
	}
	public void deleteFixup(RbTreeElement<BasicRbTreeDecorator<Object>> element) {

		RbTreeElement<BasicRbTreeDecorator<Object>> w;

		while (element != root && element.isBlack() == true) {

			if (element == element.getParent().getLeft()) {
				w = element.getParent().getRight();
				if (w.isRed()) {
					w.setColor(Color.BLACK);
					element.getParent().setColor(Color.RED);
					leftRotate(element.getParent());
					w = element.getParent().getRight();
				}

				if (w.getLeft().isBlack() && w.getRight().isBlack()) {
					w.setColor(Color.RED);
					element = element.getParent();
				}

				else {
					if (w.getRight().isBlack()) {
						w.getLeft().setColor(Color.BLACK);
						w.setColor(Color.RED);
						rightRotate(w);
						w = element.getParent().getRight();
					}
					w.setColor(element.getParent().getColor());
					element.getParent().setColor(Color.BLACK);
					w.getRight().setColor(Color.BLACK);
					leftRotate(element.getParent());
					element = root;

				}

			} else {
				w = element.getParent().getLeft();
				if (w.isRed()) {
					w.setColor(Color.BLACK);
					element.getParent().setColor(Color.RED);
					rightRotate(element.getParent());
					w = element.getParent().getLeft();
				}

				if (w.getRight().isBlack() && w.getLeft().isBlack()) {
					w.setColor(Color.RED);
					element = element.getParent();
				}

				else {
					if (w.getLeft().isBlack()) {
						w.getRight().setColor(Color.BLACK);
						w.setColor(Color.RED);
						leftRotate(w);
						w = element.getParent().getLeft();
					}
					w.setColor(element.getParent().getColor());
					element.getParent().setColor(Color.BLACK);
					w.getLeft().setColor(Color.BLACK);
					rightRotate(element.getParent());
					element = root;

				}

			}

		}

		element.setColor(Color.BLACK);
	}
}

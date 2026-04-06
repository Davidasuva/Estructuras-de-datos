package edu.uva.app.bintree;

import edu.uva.model.node.AbstractNode;

public class Root<E> extends AbstractNode<E> {

    Root<E> left;
    Root<E> right;

    public Root() {
        super();
        this.left = null;
        this.right = null;
    }

    public Root(E value) {
        super(value);
        this.left = null;
        this.right = null;
    }

    public Root<E> getRight() {
        return right;
    }

    public void setRight(Root<E> right) {
        this.right = right;
    }

    public Root<E> getLeft() {
        return left;
    }

    public void setLeft(Root<E> left) {
        this.left = left;
    }

    @Override
    public String toString(){
        return "Root{ "+
                "Left: "+left+
                " Right: "+ right;
    }
}

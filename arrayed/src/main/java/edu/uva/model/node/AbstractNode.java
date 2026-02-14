package edu.uva.model.node;

public abstract class AbstractNode<E> implements Node<E>, Cloneable {

    protected E element;

    protected AbstractNode() {
        this.element=null;
    }

    protected AbstractNode(E element){
        this.element=element;
    }

    @Override
    public void set(E element){
        this.element=element;
    }

    @Override
    public E get(){
        return element;
    }


}

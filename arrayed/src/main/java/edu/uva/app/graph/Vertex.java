package edu.uva.app.graph;

import edu.uva.model.node.AbstractNode;

public class Vertex<E> extends AbstractNode<E> {
    int numVertex;

    public Vertex() {
        numVertex = -1;
    }
    public Vertex(E element) {
        super(element);
        numVertex = -1;
    }

    public int getNumVertex() {
        return numVertex;
    }

    public void setNumVertex(int numVertex) {
        this.numVertex = numVertex;
    }

    @Override
    public String toString() {
        return element.toString()+"("+numVertex+")";
    }
}

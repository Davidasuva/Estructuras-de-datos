package edu.uva.model.queue;

public interface Queue<E> {
    E peek();
    E extract();
    boolean insert(E element);
}

package edu.uva.model.collection;

import edu.uva.model.iterable.Iterable;

public interface Collection<E> extends Iterable<E> {

    boolean clear();
    boolean contains(E element);
    boolean contains(E[] array);
    boolean contains(Collection<E> collection);
    boolean isEmpty();
    boolean reverse();
    int size();

}

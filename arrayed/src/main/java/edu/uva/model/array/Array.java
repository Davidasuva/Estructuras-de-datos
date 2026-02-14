package edu.uva.model.array;

import java.util.function.Predicate;

import edu.uva.model.collection.Collection;

public interface Array<E> {

    boolean add(E element);
    boolean add(int index, E[] array);
    boolean add(int index, Collection<E> collection);
    E get(int index);
    int indexOf(E element);
    int lastIndexOf(E element);
    boolean remove(int index);
    boolean remove(Predicate<E> filter);
    boolean remove(int from, int to);
    boolean set(int index, E element);
}

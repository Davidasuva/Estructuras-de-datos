
package edu.uva.model.iterable;

import java.util.function.Function;

import edu.uva.model.iterator.Iterator;


public interface Iterable<E> {

    void forEach(Function<E,Void> action );
    Iterator<E> iterator();

}

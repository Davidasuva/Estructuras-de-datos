package edu.uva.model.array;

import edu.uva.model.collection.AbstractCollection;
import edu.uva.model.iterator.Iterator;

public abstract class AbstractArray<E> extends AbstractCollection<E> implements BufferArray, Array<E> {

    @Override
    public boolean contains(E element){//Quiere saber si el elemento esta dentro del array
        
        Iterator<E> iterator=iterator();
        while(iterator.hasNext()){//se ejecuta el while mientras que haya otro elemento en el array
            if(iterator.next().equals(element)){ //si encuentra que el siguiente elemento esta dentro del array retorna true y si no false
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E[] array){ //aca valora si TODOS los elementos del array dado se encuentran en el array

        for(E element: array){
            if(!contains(element)){//Aca simplemente lama al metodo contains que se hizo arriba 
                return false;
            }
        }
        return true;
    }


}

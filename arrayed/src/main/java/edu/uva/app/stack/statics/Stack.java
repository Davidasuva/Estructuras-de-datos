package edu.uva.app.stack.statics;

import java.util.function.Function;

import edu.uva.app.array.Array;
import edu.uva.model.collection.Collection;
import edu.uva.model.iterator.Iterator;
import edu.uva.model.stack.AbstractStack;


public class Stack<E> extends AbstractStack<E> {

    private final Array<E> array;


    public Stack(int sizeMax){
        array=new Array<>(sizeMax);
    }

    @Override
    public E peek(){
        if(isEmpty()){
            return null;
        }
        return array.get(array.size());
    }

    @Override
    public E pop(){
        if(isEmpty()){
            return null;
        }
        E element=array.get(array.size());
        array.remove(array.size());
        return element;
    }

    @Override
    public boolean push(E element){
        if(element==null){
            return false;
        }
        return array.add(element);
    }

    @Override
    public boolean clear(){
        boolean clear=array.clear();
        return clear;
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    @Override
    public boolean contains(E element){
        return array.contains(element);
    }

    @Override
    public boolean contains(E[] element){
        return array.contains(element);
    }

    @Override
    public boolean contains(Collection<E> collection){
        return array.contains(collection);
    }

    @Override
    public boolean reverse(){
        return array.reverse();
    }

    @Override
    public int size(){
        return array.size();
    }

    @Override
    public void forEach(Function<E,Void> action){
        array.forEach(action);
    }

    @Override
    public Iterator<E> iterator(){
        return array.iterator();
    }


}

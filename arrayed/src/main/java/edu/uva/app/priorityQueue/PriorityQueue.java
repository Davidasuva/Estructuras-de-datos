package edu.uva.app.priorityQueue;
import edu.uva.model.priorityqueue.AbstractPriorityQueue;
import edu.uva.app.array.Array;
import edu.uva.model.iterator.Iterator;
import edu.uva.app.queue.list.Queue;
import edu.uva.model.collection.Collection;

import java.util.NoSuchElementException;
import java.util.function.Function;


public class PriorityQueue<E> extends AbstractPriorityQueue<E> {

    private final int prioridades;
    private final  Array<Queue<E>> array;


    public PriorityQueue(int prioridades) {
        this.prioridades = prioridades;
        array = new Array<>(prioridades);
        for(int i=0;i<prioridades;i++){
            array.add(new Queue<>());
        }
    }

    @Override
    public E peek(){
        Iterator<Queue<E>> iterator = array.iterator();
        while(iterator.hasNext()){
            Queue<E> queue = iterator.next();
            if(!queue.isEmpty()){
                return queue.peek();
            }
        }
        return null;
    }

    @Override
    public E extract(){
        Iterator<Queue<E>> iterator = array.iterator();
        while(iterator.hasNext()){
            Queue<E> queue = iterator.next();
            if(!queue.isEmpty()){
                return queue.extract();
            }
        }
        return null;
    }

    @Override
    public boolean insert(E element){
        return  array.get(prioridades-1).insert(element);
    }

    @Override
    public boolean insert(int index, E element){
        if(index<0||index>=prioridades){
            return false;
        }
        return array.get(index).insert(element);
    }

    @Override
    public int size() {
        int tamaños=0;
        for(int i=0;i<prioridades;i++){
            tamaños+=array.get(i).size();
        }
        return tamaños;
    }
    @Override
    public boolean isEmpty() {
        for(int i =0;i<prioridades;i++){
            if(!array.get(i).isEmpty()){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean clear(){
        for(int i =0;i<prioridades;i++){
            array.get(i).clear();
        }
        return true;
    }

    @Override
    public boolean contains(Collection<E> collection) {
        for(int i =0;i<prioridades;i++){
            if(array.get(i).contains(collection)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E element){
        for(int i =0;i<prioridades;i++){
            if(array.get(i).contains(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E[] array){
        for(int i =0;i<prioridades;i++){
            if(this.array.get(i).contains(array)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean reverse(){
        for(int i =0;i<prioridades;i++){
            array.get(i).reverse();
        }
        return true;
    }

    @Override
    public void forEach(Function<E, Void> action){
        for(int i =0;i<prioridades;i++){
            array.get(i).forEach(action);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>(){
            int prioridad=0;
            Iterator<E> iteratorQueue=array.get(0).iterator();

            @Override
            public boolean hasNext() {
                 while(prioridad<prioridades){
                     if(iteratorQueue.hasNext()){
                         return true;
                     }
                     prioridad++;
                     if(prioridad<prioridades){
                         iteratorQueue=array.get(prioridad).iterator();
                     }
                 }
                 return false;
            }

            @Override
            public E next() {
                if(!hasNext()){
                    throw new NoSuchElementException("No more elements");
                }
                return iteratorQueue.next();
            }
        };
    }


}

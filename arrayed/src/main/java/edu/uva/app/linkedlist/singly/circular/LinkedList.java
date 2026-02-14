package edu.uva.app.linkedlist.singly.circular;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import edu.uva.app.linkedlist.node.singly.circular.LinkedNode;
import edu.uva.model.collection.Collection;
import edu.uva.model.iterator.Iterator;
import edu.uva.model.list.AbstractList;
import edu.uva.model.list.List;

public class LinkedList<E> extends AbstractList<E>{

    private int size;
    private LinkedNode<E> head;
    private LinkedNode<E> flag;

    public LinkedList(){
        size=0;
        this.head=this.flag=null;
    }

    public LinkedList(E element){
        size=1;
        LinkedNode<E> node=new LinkedNode<>(element);
        this.head=this.flag=node;
    }

    @Override
    public boolean isEmpty(){
        return this.head==null;
    }

    @Override
    public int size(){
        return size;
    }
    
    @Override
    public E peek(){
        if(isEmpty()){
            return null;
        }
        return this.head.get();
    }

    @Override
    public E peekLast(){
        if(isEmpty()){
            return null;
        }
        return this.flag.get();
    }
    
    @Override
    public boolean add(E element){
        try {
            LinkedNode<E> node=new LinkedNode<>(element);
            if(isEmpty()){
                this.head=this.flag=node;
                flag.setNext(head);
            }else{
                this.flag.setNext(node);
                this.flag=node;
                this.flag.setNext(head);
            }
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean add(E[] array){
        try {
            for(E x:array){
                add(x);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean add(Collection<E> collection){
        try {
            Iterator<E> iterator=collection.iterator();
            while(iterator.hasNext()){
                add(iterator.next());
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addFirst(E element){
        try {
            LinkedNode<E> node=new LinkedNode<>(element);
            if(isEmpty()){
                this.head=this.flag=node;
            }else{
                node.setNext(this.head);
                this.head=node;
                flag.setNext(head);
            }
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public boolean addFirst(E[] array){
        try {
            for(E x:array){
                addFirst(x);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addFirst(Collection<E> collection){
        try{
            Iterator<E> iterator=collection.iterator();
            while(iterator.hasNext()){
                addFirst(iterator.next());
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public E[] peekArray(int cuantity){
        Object array=new Object[cuantity];
        if(isEmpty()){
            return array;
        }
        if(size<cuantity){
            return array;
        }

        LinkedNode<E> node=head;
        for(int i=0; i<array.length;i++){
            
        }
    }

    //Parte de Iterator
    @Override
    public Iterator<E> iterator(){ //Aca es el método que nos permite retornar un iterador
        return new Iterator<E>(){ //Aca se retorna el iterador, la cosa es que dentro de este se esta definiendo los métodos que este posee. es una clase anonima segun busqué

            int contador=0;
                private LinkedNode<E> current=head;


            @Override
            public boolean hasNext(){
                return contador<size;
            }

            @Override
            public E next(){
                if(!hasNext()){
                    throw new IllegalStateException("No more elements");
                }
                E element=current.get();
                current=current.getNext();
                contador++;
                return element; //Aca se va avanzando entre los nodos y se va retornando el elemento que se tenga
            }
        };
    }


}

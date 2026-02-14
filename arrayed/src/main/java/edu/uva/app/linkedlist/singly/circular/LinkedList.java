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
    public boolean clear(){
        try {
            this.head=this.flag=null;
            size=0;
            return true;
        } catch (Exception e) {
            return false;
        }
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
    public boolean contains(E element){
        if(isEmpty()){
            return false;
        }
        if(element==null){
            return false;
        }
        LinkedNode<E> node=head;
        do{
            if(node.get().equals(element)){
                return true;
            }
            node=node.getNext();
        }while(node!=head);
        return false;
    }

    @Override
    public boolean contains(E[] array){
        if(array==null||isEmpty()){
            return false;
        }
        if(array.length==0){
            return true;
        }
        for(E x:array){
            if(!contains(x)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Collection<E> collection){
        if(collection==null||isEmpty()){
            return false;
        }
        if(collection.size()==0){
            return true;
        }
        Iterator<E> iterator=collection.iterator();
        while(iterator.hasNext()){
            if(!contains(iterator.next())){
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] peekArray(int cuantity){
        Object[] array=new Object[cuantity];
        if(isEmpty()||cuantity<=0){
            return (E[])array;
        }
        if(size<cuantity){
            return (E[]) array;
        }

        LinkedNode<E> node=head;
        for(int i=0; i<array.length;i++){
            array[i]=node.get();
            node=node.getNext();
        }
        return (E[])array;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] peekLastArray(int cuantity){
        Object[] array=new Object[cuantity];
        if(isEmpty() || cuantity<=0){
            return (E[])array;
        }
        if(size<cuantity){
            return (E[])array;
        }
        LinkedNode<E>node=head;
        for(int i=0;i<size-cuantity;i++){
            node=node.getNext();
        }

        for(int ii=0;ii<cuantity;ii++){
            array[ii]=node.get();
            node=node.getNext();
        }
        return(E[])array;
    }
    
    @Override
    public List<E> peekCollection(int cuantity){
        List<E> list=new LinkedList<>();
        if(isEmpty()||cuantity<=0){
            return list;
        }

        if(size<cuantity){
            return list;
        }
        
        LinkedNode<E> node=head;
        for(int i=0;i<cuantity;i++){
            list.add(node.get());
            node=node.getNext();
        }
        return list;
    }

    @Override
    public List<E> peekLastCollection(int cuantity){
        List<E> list=new LinkedList<>();
        if(isEmpty()||cuantity<=0){
            return list;
        }
        if(size<cuantity){
            return list;
        }
        LinkedNode<E> node=head;
        for(int i=0;i<size-cuantity;i++){
            node=node.getNext();
        }
        for(int i=0;i<cuantity;i++){
            list.add(node.get());
            node=node.getNext();
        }
        return list;
    }

    @Override
    public boolean remove(E element){
        if(isEmpty()||element==null){
            return false;
        }
        LinkedNode<E> node=head;
        LinkedNode<E> previous=flag;
        if(size==1){
            if(head.get().equals(element)){
                clear();
                return true;
            }else{
                return false;
            }
        }else{
            do{
                if(node.get().equals(element)&&node==head){
                    head=head.getNext();
                    flag.setNext(head);
                    size--;
                    return true;
                }
                if(node.get().equals(element) && node!=flag){
                    previous.setNext(node.getNext());
                    size--;
                    return true;
                }else if(node.get().equals(element)&&node==flag){
                    previous.setNext(head);
                    flag=previous;
                    size--;
                    return true;
                }
                previous=node;
                node=node.getNext();
            }while(node!=head);
        }
        return false;
    }

    @Override
    public boolean remove(E[] array){
        if(isEmpty()){
            return false;
        }
        if(size<array.length){
            return false;
        }
        for(E x:array){
            while(remove(x)){}
        }
        return true;
    }
    @Override
    public boolean remove(Collection<E> collection){
        if(isEmpty()){
            return false;
        }
        if(size<collection.size()){
            return false;
        }
        
        Iterator<E> iterator = collection.iterator();
        while(iterator.hasNext()){
            while(remove(iterator.next())){
            }
        }
        return true;
    }

    @Override
    public boolean remove(Predicate<E> filter){
        if(isEmpty() || filter==null){
            return false;
        }
        int count=size;
        LinkedNode<E> node=head;
        for(int i=0;i<count;i++){
            LinkedNode<E> next=node.getNext();
            if(filter.test(node.get())){
                remove(node.get());
            }
            node=next;
            if(isEmpty()){
                break;
            }
        }
        return true;
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

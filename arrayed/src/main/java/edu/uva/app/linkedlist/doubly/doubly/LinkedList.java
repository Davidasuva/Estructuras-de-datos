package edu.uva.app.linkedlist.doubly.doubly;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import edu.uva.app.linkedlist.node.doubly.doubly.LinkedNode;
import edu.uva.model.collection.Collection;
import edu.uva.model.iterator.Iterator;
import edu.uva.model.list.AbstractList;
import edu.uva.model.list.List;

public class LinkedList<E> extends AbstractList<E> {

    private int size;
    private LinkedNode<E> head;
    private LinkedNode<E> tail;

    public LinkedList(){
        size=0;
        this.head=this.tail=null;
    }

    public LinkedList(E element){
        size=1;
        LinkedNode<E> node=new LinkedNode<E>(element);
        this.head=this.tail=node;
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
            this.head=null;
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
        return this.tail.get();
    }

    @Override
    public boolean add(E element){
        try {
            LinkedNode<E> node=new LinkedNode<>(element);
            if(isEmpty()){
                this.head=this.tail=node;
            }else{
                LinkedNode<E> previous=this.tail;
                this.tail.setNext(node);
                this.tail=node;
                tail.setPrevious(previous);
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
                this.head=this.tail=node;
            }else{
                node.setNext(this.head);
                head.setPrevious(node);
                head=node;
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
        try {
            Iterator<E> iterator=collection.iterator();
            while(iterator.hasNext()){
                addFirst(iterator.next());
            }
            return true;
        } catch (Exception e) {
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
        while(node!=null){
            if(node.get().equals(element)){
                return true;
            }
            node=node.getNext();
        }
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
        if(isEmpty()||collection==null){
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
        if(isEmpty()||cuantity<=0||size<cuantity){
            return(E[])array;
        }
        LinkedNode<E> node=head;
        for(int i=0;i<cuantity; i++){
            array[i]=node.get();
            node=node.getNext();
        }

        return(E[])array;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] peekLastArray(int cuantity){
        Object[] array=new Object[cuantity];
        if(isEmpty()||cuantity<=0||size<cuantity){
            return(E[])array;
        }
        LinkedNode<E> node=tail;
        for(int i=0;i<cuantity; i++){
            array[i]=node.get();
            node=node.getPrevious();
        }
        return (E[])array;
    }
    
    @Override
    public List<E> peekCollection(int cuantity){
        List<E> list=new LinkedList<>();
        if(isEmpty()||cuantity<=0||size<cuantity){
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
        if(isEmpty()||cuantity<=0||size<cuantity){
            return list;
        }
        LinkedNode<E> node=tail;
        for(int i=0;i<cuantity;i++){
            list.add(node.get());
            node=node.getPrevious();
        }
        return list;
    }

    @Override
    public boolean remove(E element){
        if(isEmpty()||element==null){
            return false;
        }
        LinkedNode<E> node=head;
        if(size==1){
            if(head.get().equals(element)){
                clear();
                return true;
            }else{
                return false;
            }
        }else{
            while(node!=null){
                if(node.get().equals(element)&&node==head){
                    head=head.getNext();
                    head.setPrevious(null);
                    size--;
                    return true;
                }
                if(node.get().equals(element) && node!=tail){
                    node.getPrevious().setNext(node.getNext());
                    node.getNext().setPrevious(node.getPrevious());
                    size--;
                    return true;
                }else if(node.get().equals(element)&&node==tail){
                    tail=node.getPrevious();
                    tail.setNext(null);
                    size--;
                    return true;
                }
                node=node.getNext();
            }
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

    @Override
    public E poll(){
        if(isEmpty()){
            return null;
        }
        E element=head.get();
        if(size==1){
            clear();
            return element;
        }
        head=head.getNext();
        head.setPrevious(null);
        size--;
        return element;
    }

    @Override
    public E pollLast(){
        if(isEmpty()){
            return null;
        }
        E element=tail.get();
        if(size==1){
            clear();
            return element;
        }
        tail=tail.getPrevious();
        tail.setNext(null);
        size--;
        return element;
    }
    @Override
    public E[] pollArray(int cuantity){

        if(isEmpty()||cuantity<=0){
            return null;
        }
        if(size<cuantity){
            return null;
        }
        E[] array=peekArray(cuantity);
        for(int i=0;i<cuantity;i++){
            poll();
        }
        return array;
    }

    @Override
    public E[] pollLastArray(int cuantity){
        if(isEmpty()||cuantity<=0){
            return null;
        }
        if(size<cuantity){
            return null;
        }
        E[] array=peekLastArray(cuantity);
        for(int i=0;i<cuantity;i++){
            pollLast();
        }
        return array;
    }
    @Override
    public List<E> pollCollection(int cuantity){

        if(isEmpty()||cuantity<=0){
            return null;
        }
        if(size<cuantity){
            return null;
        }
        List<E> collection=peekCollection(cuantity);
        for(int i=0;i<cuantity;i++){
            poll();
        }
        return collection;
    }
    @Override
    public List<E> pollLastCollection(int cuantity){

        if(isEmpty()||cuantity<=0){
            return null;
        }
        if(size<cuantity){
            return null;
        }
        List<E> collection=peekLastCollection(cuantity);
        for(int i=0;i<cuantity;i++){
            pollLast();
        }
        return collection;
    }

    @Override
    public boolean set(E index, E element){
        if(isEmpty()){
            return false;
        }
        if(element==null||index==null){
            return false;
        }
        LinkedNode<E> node=head;
        while(node!=null){
            if(node.get().equals(index)){
                node.set(element);
                return true;
            }
            node=node.getNext();
        }
        return false;
    }

    @Override
    public boolean replace(E element, E newElement, Predicate<E> comparator){
        if(comparator==null||element==null||newElement==null){
            return false;
        }
        if(isEmpty()){
            return false;
        }
        LinkedNode<E> node=head;
        while(node!=null){
            if(node.get().equals(element)){
                if(comparator.test(node.get())){
                    node.set(newElement);
                }
                node=node.getNext();
            }
        }
        return false;
        
    }
    @Override
    public boolean replace(E[] array, E[] newArray, Predicate<E> comparator){
        if(isEmpty()){
            return false;
        }
        if(comparator==null){
            return false;
        }
        if(array.length!=newArray.length){
            return false;
        }
        if(size<array.length){
            return false;
        }

        for(int i=0; i<array.length;i++){
            replace(array[i],newArray[i],comparator);
        }
        return true;
    }
    
    @Override
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator){
        if(isEmpty()||collection==null||newCollection==null){
            return false;
        }
        if(comparator==null){
            return false;
        }
        if(collection.size()!=newCollection.size()){
            return false;
        }
        if(size<collection.size()){
            return false;
        }
        Iterator<E> iterator=collection.iterator();
        Iterator<E> iterator2=newCollection.iterator();
        while(iterator.hasNext()){
            replace(iterator.next(),iterator2.next(),comparator);
        }
        return true;
    }



    //Iterator part
    @Override
    public Iterator<E> iterator(){
        return new Iterator<E>(){
            private LinkedNode<E> front=head;
            private LinkedNode<E> back=tail;

            @Override
            public boolean hasNext(){
                return front!=null;
            }

            @Override
            public E next(){
                if(!hasNext()){
                    throw new IllegalStateException("No more elements");
                }
                E element=front.get();
                front=front.getNext();
                return element;
            }

            public boolean hasPrevious(){
                return back!=null;
            }
            
            public E previous(){
                if(!hasPrevious()){
                    throw new IllegalStateException("No more elements");
                }
                E element=back.get();
                back=back.getPrevious();
                return element;
            }


        };
    }

}

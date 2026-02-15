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
        if(element==null){
            return false;
        }
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
    }

    @Override
    public boolean add(E[] array){
        if(array==null){
            return false;
        }
        for(E x:array){
            add(x);
        }
        return true;
    }

    @Override
    public boolean add(Collection<E> collection){
        if(collection==null){
            return false;
        }
        Iterator<E> iterator=collection.iterator();
        while(iterator.hasNext()){
            add(iterator.next());
        }
        return true;
    }

    @Override
    public boolean addFirst(E element){
        if(element==null){
            return false;
        }
        LinkedNode<E> node=new LinkedNode<>(element);
        if(isEmpty()){
            node.setNext(node);
            this.head=this.flag=node;
        }else{
            node.setNext(this.head);
            this.head=node;
            flag.setNext(head);
        }
        size++;
        return true;
    }
    @Override
    public boolean addFirst(E[] array){
        if(array==null){
            return false;
        }
        for(E x:array){
            addFirst(x);
        }
        return true;
    }

    @Override
    public boolean addFirst(Collection<E> collection){
        if(collection==null){
            return false;
        }
        Iterator<E> iterator=collection.iterator();
        while(iterator.hasNext()){
            addFirst(iterator.next());
        }
        return true;
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
            E val=iterator.next();
            while(remove(val)){
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
        E element= head.get();
        if(size==1){
            clear();
            return element;
        }
        head=head.getNext();
        flag.setNext(head);
        size--;
        return element;
    }

    @Override
    public E pollLast(){
        if(isEmpty()){
            return null;
        }
        E element=flag.get();
        LinkedNode<E> node=head;
        if(size==1){
            clear();
            return element;
        }

        while(node.getNext()!=flag){
            node=node.getNext();
        }

        node.setNext(head);
        flag=node;
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
        do { 
            if(node.get().equals(index)){
                node.set(element);
                return true;
            }
            node=node.getNext();
        } while (node!=head);
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
        do { 
            if(node.get().equals(element)){
                if(comparator.test(node.get())){
                    node.set(newElement);
                }
            }
            node=node.getNext();
        } while (node!=head);
        return true;
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

    @Override
    public boolean retain(E[] array){
        if(isEmpty()){
            return false;
        }
        if(array==null){
            return false;
        }
        LinkedNode<E> node=head;
        do{
            boolean found=false;
            LinkedNode<E> next=node.getNext();

            for(E element:array){
                if(node.get().equals(element)){
                    found=true;
                    break;
                }
            }
            if(!found){
                remove(node.get());
            }
            node=next;
        }while(node!=head);
        return true;
    }
    @Override
    public boolean retain(Collection<E> collection){
        if(isEmpty()){
            return false;
        }
        if(collection==null){
            return false;
        }
        LinkedNode<E> node=head;
        do { 
            boolean found=false;
            Iterator<E> iterator=collection.iterator();
            LinkedNode<E> next=node.getNext();
            while(iterator.hasNext()){
                if(node.get().equals(iterator.next())){
                    found=true;
                    break;
                }
            }
            if(!found){
                remove(node.get());
            }
            node=next;
        } while(node!=head);
        return true;
    }

    @Override
    public List<E> subList(E from, E to){
        List<E> list=new LinkedList<>();
        if(from==null||to==null){
            return list;
        }
        if(isEmpty()){
            return list;
        }
        boolean start=false;
        LinkedNode<E> node=head;
        do { 
            if(node.get().equals(to)&&!start){
                return list;
            }
            if(node.get().equals(from)){
                start=true;
            }
            if(start){
                list.add(node.get());
            }
            if(node.get().equals(to)){
                break;
            }
            node=node.getNext();
        } while (node!=head);
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray(){
        Object[] array= new Object[size];
        if(isEmpty()){
            return (E[])array;
        }
        LinkedNode<E> node=head;
        for(int i=0;i<size;i++){
            array[i]=node.get();
            node=node.getNext();
        }

        return(E[])array;
    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean sort(ToIntFunction<E> toInt){
        if(toInt==null||size<2){
            return false;
        }
        Object[] array=toArray();
        for(int x=0;x<size;x++){
            for(int y=0;y<size-x-1;y++){
                int a=toInt.applyAsInt((E)array[y]);
                int b=toInt.applyAsInt((E)array[y+1]);

                if(a>b){
                    Object temporal=array[y];
                    array[y]=array[y+1];
                    array[y+1]=temporal;
                }
            }
        }

        LinkedNode<E> node=head;
        int i=0;
        do{
            node.set((E)array[i++]);
            node=node.getNext();
        }while(node!=head);
        return true;
    }

    @Override
    public boolean reverse(){
        if(isEmpty()||size<2){
            return false;
        }
        LinkedNode<E> node=head;
        LinkedNode<E> previous=flag;

        do { 
            LinkedNode<E> next=node.getNext();
            node.setNext(previous);
            previous=node;
            node=next;

        } while (node!=head);
        LinkedNode<E> temp=head;
        head=flag;
        flag=temp;
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

    @Override
    public void forEach(Function<E,Void> action){
        if(isEmpty()){
            return;
        }
        if(action==null){
            return;
        }
        LinkedNode<E> node=head;
        do { 
            action.apply(node.get());
            node=node.getNext();
        } while (node!=head);
    }




}

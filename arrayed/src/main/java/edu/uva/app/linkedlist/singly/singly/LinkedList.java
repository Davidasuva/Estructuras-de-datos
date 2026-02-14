package edu.uva.app.linkedlist.singly.singly;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import edu.uva.app.linkedlist.node.singly.singly.LinkedNode;
import edu.uva.model.collection.Collection;
import edu.uva.model.iterator.Iterator;
import edu.uva.model.list.AbstractList;
import edu.uva.model.list.List;

public class LinkedList<E> extends AbstractList<E>{

    private int size;
    private LinkedNode<E> head;
    private LinkedNode<E> cola;

    public LinkedList(){
        size=0;
        this.head=this.cola=null;
    }

    public LinkedList(E element){
        size=1;
        LinkedNode<E> node=new LinkedNode<>(element);
        this.head=this.cola=node;
    }

    @Override
    public boolean isEmpty(){
        return this.head==null;
    }

    @Override
    public String toString() {
        return "LinkedList [Head= "+head+" ] ";
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
        return this.cola.get();
    }

    @Override
    public boolean add(E element){
        try {
            if(isEmpty()){
                LinkedNode<E> node=new LinkedNode<>(element);
                this.head=this.cola=node;
            }else{
                LinkedNode<E> node=new LinkedNode<>(element);
                this.cola.setNext(node);
                this.cola=node;
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

            for(E element: array){
                add(element);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public boolean add(Collection<E> collection){
        try {
           Iterator<E> iterator= collection.iterator();
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
                this.head=this.cola=node;
            }else{
                node.setNext(this.head);
                this.head=node;
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
            for(E element: array){
                addFirst(element);
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
    public E[] peekArray(int cuantity){
        if(isEmpty()){
            return null;
        }
        if(size<cuantity){
            return null;
        }

        LinkedNode<E> n=head;
        int iterator=0;
        @SuppressWarnings("unchecked")
        E[] array=(E[]) new Object[cuantity]; 
        while(iterator<cuantity){
            array[iterator]=n.get();
            n = n.getNext();
            iterator++;
        }
        return array;
    }

    @Override
    public E[] peekLastArray(int cuantity){
        if(isEmpty()){
            return null;
        }
        if(size<cuantity){
            return null;
        }
        LinkedNode<E> n=head;
        @SuppressWarnings("unchecked")
        E[] array=(E[]) new Object[cuantity]; 
        for(int i=0;i<size-cuantity;i++){
            n=n.getNext();
        }

        for(int ii=0 ; ii<cuantity ; ii++){
            array[ii]=n.get();
            n=n.getNext();
        }

        return array;
    }

    @Override
    public List<E> peekCollection(int cuantity){
        if(isEmpty()){
            return null;
        }
        if(size<cuantity){
            return null;
        }
        List<E> list=new LinkedList<>();
        LinkedNode<E> node=head;
        for(int i=0; i<cuantity;i++){
            list.add(node.get());
            node=node.getNext();
        }
        return list;
    }

    @Override
    public List<E> peekLastCollection(int cuantity){
        if(isEmpty()){
            return null;
        }
        if(size<cuantity){
            return null;
        }

        List<E> list=new LinkedList<>();
        LinkedNode<E> node=head;
        for(int i=0; i<size-cuantity; i++){
            node=node.getNext();
        }

        for(int i=0; i<cuantity;i++){
            list.add(node.get());
            node=node.getNext();
        }
        return list;
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
        size--;
        return element;
    }

    @Override
    public E pollLast(){
        if(isEmpty()){
            return null;
        }
        E element=cola.get();
        LinkedNode<E> node=head;
        if(size==1){
            clear();
            return element;
        }
        while(node.getNext()!=cola){
            node=node.getNext();
        }

        node.setNext(null);
        cola=node;
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
        for(int i=0; i<cuantity;i++){
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
        for(int i=0; i<cuantity;i++){
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

        List<E> list= peekCollection(cuantity);
        for(int i=0; i<cuantity;i++){
            poll();
        }
        return list;
    }

    @Override
    public List<E> pollLastCollection(int cuantity){
        if(isEmpty()||cuantity<=0){
            return null;
        }
        if(size<cuantity){
            return null;
        }

        List<E> list= peekLastCollection(cuantity);
        for(int i=0; i<cuantity;i++){
            pollLast();
        }
        return list;
    }

    @Override
    public boolean remove(E element){
        if(isEmpty()){
            return false;
        }
        LinkedNode<E> previous=null;
        LinkedNode<E> n=head;

        while(n!=null && !n.get().equals(element) ){
            previous=n;
            n=n.getNext();

        }

        if(n==null){
           return false; 
        }
        if(n==head){
            if(size==1){
                clear();
            }else{
                head=head.getNext();
                size--;
            }
            return true;
        }
        if(n==cola){
            previous.setNext(null);
            cola=previous;
            size--;
            return true;
        }
        previous.setNext(n.getNext());
        size--;
        return true;
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
            while(remove(x)){ }
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
        
        Iterator<E> iterator2 = collection.iterator();
        while(iterator2.hasNext()){
            while(remove(iterator2.next())){
            }
        }
        return true;
    }

    @Override 
    public boolean remove(Predicate<E> filter){
        if(filter==null){
            return false;
        }
        if(isEmpty()){
            return false;
        }

        LinkedNode<E> node=head;
        while(node!=null){
            LinkedNode<E> next=node.getNext();
            if(filter.test(node.get())){
                remove(node.get());
            }
            node=next;
        }
        return true;
    }

    @Override
    public boolean replace(E element,E newElement, Predicate<E> comparator ){
        if(comparator==null||element==null||newElement==null){
            return false;
        }
        if(isEmpty()){
            return false;
        }

        for(LinkedNode<E> node=head; node!=null; node=node.getNext()){
            if(node.get().equals(element)){
                if(comparator.test(node.get())){
                    node.set(newElement);
                }
            }
            
        }
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
        if(isEmpty()){
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
    public boolean set(E index, E element){
        if(isEmpty()){
            return false;
        }
        if(element==null||index==null){
            return false;
        }

        for(LinkedNode<E> node=head; node!=null; node=node.getNext()){
            if(node.get().equals(index)){
                node.set(element);
                return true;
            }
        }
        return false;
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
        while(node!=null){
            boolean found=false;
            LinkedNode<E> next = node.getNext();

            for(E element: array){
                if(node.get().equals(element)){
                    found=true;
                    break;
                }
            }
            if(!found){
                remove(node.get());
            }
            node=next;
        }
        
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
        while(node!=null){
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
        }
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
        while(node!=null){
            if(node.get().equals(to) && !start){
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
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray(){
        Object[] array=new Object[size];
        if(isEmpty()){
            return (E[]) array;
        }
        int iterator=0;
        for(LinkedNode<E> node=head; node!=null;node=node.getNext()){
            array[iterator]=node.get();
            iterator++;
        }

        return (E[]) array;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean sort(ToIntFunction<E> toInt){
        if(toInt==null || size<2){
            return false;
        }

        Object[] array= toArray();

        for(int x=0;x<array.length-1;x++){
            for(int y=0;x<array.length-1-x;y++){

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
        while(node!=null){
            node.set((E)array[i++]);
            node=node.getNext();
        }


        return true;

    }

    //La parte de collection
    @Override
    public int size(){
        return this.size;

    }
    @Override
    public boolean clear(){
        try{
            head=cola=null;
            size=0;
            return true;
        }catch(Exception e){
            return false;
        }
    } 

    @Override
    public boolean contains(E element){
        for(LinkedNode<E> node=head; node!=null; node=node.getNext()){
            if(node.get().equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E[] array){
        if(array==null){
            return false;
        }
        for(E x: array){
           if(!contains(x)){
            return false;
           }
        }
        return true;     
    }

    @Override
    public boolean contains(Collection<E> collection){
        if(collection==null){
            return false;
        }
        Iterator<E> iterator=collection.iterator();
        while(iterator.hasNext()){
            if(!contains(iterator.next())){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean reverse(){
        if(isEmpty()||size<2){
            return false;
        }

        LinkedNode<E> current=head;
        LinkedNode<E> previous=null;
        cola=head;

        while(current!=null){
            LinkedNode<E> next=current.getNext();
            current.setNext(previous);
            previous=current;
            current=next;
        }

        head=previous;
        return true;
    }
     //La parte de Iterator

    @Override
    public void forEach(Function<E,Void> action ){
        if(action==null){
            return;
        }

        for(LinkedNode<E> node=head; node!=null;node=node.getNext()){
            action.apply(node.get());
        }
    }

    @Override
    public Iterator<E> iterator(){ //Aca es el método que nos permite retornar un iterador
        
        return new Iterator<E>(){ //Aca se retorna el iterador, la cosa es que dentro de este se esta definiendo los métodos que este posee. es una clase anonima segun busqué
            private LinkedNode<E> current=head;


            @Override
            public boolean hasNext(){
                return current!=null; //Si el nodo actual es diferente de null
            }

            @Override
            public E next(){
                if(!hasNext()){
                    throw new IllegalStateException("No more elements");
                }
                E element=current.get();
                current=current.getNext();
                return element; //Aca se va avanzando entre los nodos y se va retornando el elemento que se tenga
            }
        };
    }
}

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

    public LinkedList(){ //Here we have the builder, with no elements. making the size 0, the head and the tail null
        size=0;
        this.head=this.cola=null;
    }

    public LinkedList(E element){
        size=1;
        LinkedNode<E> node=new LinkedNode<>(element); //Here we have another builder with a element, making the size, and te head ant he tail the element.
        this.head=this.cola=node;
    }

    @Override
    public boolean isEmpty(){
        return this.head==null; //This method verificates if the head is null, if the head is null, it means the list is empty.
    }

    @Override
    public String toString() {
        LinkedNode<E> node=head;
        String string;
        if(node==null){
            string="LinkedList: Empty";
        }else{
            string ="LinkedList: "+node.toString();
        }
        return string;
    }

    @Override
    public E peek(){ //This method return the first element of the list
        if(isEmpty()){
            return null;
        }
        return this.head.get();
    }

    @Override
    public E peekLast(){//Returns the last element of the list
        if(isEmpty()){
            return null;
        }
        return this.cola.get();
    }

    @Override
    public boolean add(E element){//Adds a element in the tail of the list
        if(element==null){//Verificates if the elements is null
            return false;
        }
        if(isEmpty()){//if the list is empty
            LinkedNode<E> node=new LinkedNode<>(element);
            this.head=this.cola=node;//The noded who was added is ubicated in the head and tail
        }else{
            LinkedNode<E> node=new LinkedNode<>(element);
            this.cola.setNext(node);//If the list isn't empty so the the next of the tail is the new node
            this.cola=node;//and the tail is now the new node
        }
        size++;//the size increase because of the new element
        return true;
    }
    
    @Override
    public boolean add(E[] array){//Add all the elements of an array in the list
        if(array==null){//Verificates if the array is null
            return false;
        }
        for(E element: array){//For each element of the array it will be added in the list with the previous method
            add(element);
        }
        return true;
    }

    @Override
    public boolean add(Collection<E> collection){//add all the elements of the collection in the list
        if(collection==null){//Verificates if the collection is null
            return false;
        }
        Iterator<E> iterator= collection.iterator();//Creates a iterator, to move forward into the collection
        while(iterator.hasNext()){//if the collection has next each element will be added into the list
            add(iterator.next());
        }
        return true;
    }
    @Override
    public boolean addFirst(E element){//add a element in the head of the list
        if(element==null){//Verificates if the element is null
            return false;
        }
        LinkedNode<E> node=new LinkedNode<>(element);
        if(isEmpty()){//if the list is empty the new node will be the head and the tail at the same time
            this.head=this.cola=node;
        }else{
            node.setNext(this.head);
            this.head=node;//If the list isn't empty the next of the new node will be the head, and the head now will be the new node
        }
        size++;
        return true;
    }

    @Override
    public boolean addFirst(E[] array){//All at the first place of the list all elements of the array
        if(array==null){//Verificates if the array is null
            return false;
        }
        for(E element: array){//For each element of the array it will be added first in the list with the previous method
            addFirst(element);
        }
        return true;
    }

    @Override
    public boolean addFirst(Collection<E> collection){//All elements of the collection will be added at the first place in the list
        if(collection==null){//Verificates if the collection is null
            return false;
        }
        Iterator<E> iterator=collection.iterator();//Creates a new iterator to moves forward into the list
        while(iterator.hasNext()){
            addFirst(iterator.next());//each element of the collection will be added in the list
        }
        return true;
    }

    @Override
    public E[] peekArray(int cuantity){//Get a cuantity of elements of the array and put it into an array, returning the array
        if(isEmpty()||cuantity<=0){
            return null;//Verificates if the list is empty and the cuantity of elements is bigger than 0
        }
        if(size<cuantity){
            return null;//Verificates if the cuantity don't exceed the size of the list
        }

        LinkedNode<E> n=head;//the first node starts in the head
        int iterator=0;//An iterator to move forward into the array
        @SuppressWarnings("unchecked")
        E[] array=(E[]) new Object[cuantity]; //Creates a new array of elements
        while(iterator<cuantity){//it moves forward until the iterator is equal the cuantity
            array[iterator]=n.get();//set the element of the node in the posotion of the iterator
            n = n.getNext();//the node now is the next node
            iterator++;//the iterator increase
        }
        return array;
    }

    @Override
    public E[] peekLastArray(int cuantity){//Get an array of the last elements of the list
        if(isEmpty()||cuantity<=0){
            return null;
        }
        if(size<cuantity){
            return null;
        }
        LinkedNode<E> n=head;
        @SuppressWarnings("unchecked")
        E[] array=(E[]) new Object[cuantity]; 
        for(int i=0;i<size-cuantity;i++){
            n=n.getNext();//Moves forward until the cuantity of the last elements
        }

        for(int ii=0 ; ii<cuantity ; ii++){
            array[ii]=n.get();
            n=n.getNext();//adds to the array the las elements
        }

        return array;
    }

    @Override
    public List<E> peekCollection(int cuantity){//get a collection with the first elements of the list
        if(isEmpty()||cuantity<=0){
            return null;
        }
        if(size<cuantity){
            return null;
        }
        List<E> list=new LinkedList<>();//create a new list to save the elements
        LinkedNode<E> node=head;//starts in the first node of the list
        for(int i=0; i<cuantity;i++){
            list.add(node.get());//it will adding the nodes of the list
            node=node.getNext();
        }
        return list;
    }

    @Override
    public List<E> peekLastCollection(int cuantity){//Get the last elements of the list in a collection
        if(isEmpty()||cuantity<=0){
            return null;
        }
        if(size<cuantity){
            return null;
        }

        List<E> list=new LinkedList<>();
        LinkedNode<E> node=head;
        for(int i=0; i<size-cuantity; i++){
            node=node.getNext();//moves forward until the cuantity of elements
        }

        for(int i=0; i<cuantity;i++){
            list.add(node.get());//Starts to adding elements to the new list
            node=node.getNext();
        }
        return list;
    }

    @Override
    public E poll(){//Get the first element, and eliminate then of the list
        if(isEmpty()){
            return null;
        }
        E element= head.get();//Save the first element of the list
        if(size==1){//if we only have the head, it will clear all the list
            clear();
            return element;
        } 
        head=head.getNext();//Else the new head will be the next node of the list
        size--;//decrease the size of the list
        return element;
    }

    @Override
    public E pollLast(){//get the last element, and eliminate then of the list
        if(isEmpty()){
            return null;
        }
        E element=cola.get();//saves the las element
        LinkedNode<E> node=head;
        if(size==1){//Same af the previous method, if whe only have one node, we will clear all the list
            clear();
            return element;
        }
        while(node.getNext()!=cola){//It will move forward until the next element of the list is the tail
            node=node.getNext();
        }

        node.setNext(null);//set the next(tail) element null
        cola=node;//making the new tail the node
        size--;//decrease the size of the list
        return element;
    }

    @Override
    public E[] pollArray(int cuantity){//Get the first elements of the list, and save them in an array
        if(isEmpty()||cuantity<=0){
            return null;
        }
        if(size<cuantity){
            return null;
        }

        E[] array=peekArray(cuantity); //Uses the previous method to get the array
        for(int i=0; i<cuantity;i++){
            poll();//Eliminates the cuantity of elements of the array
        }
        return array;
    }

    @Override
    public E[] pollLastArray(int cuantity){//get the last elements of the list, and save them in an array
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
    public List<E> pollCollection(int cuantity){//get the first elements of the list, and save them in a collection
        if(isEmpty()||cuantity<=0){
            return null;
        }
        if(size<cuantity){
            return null;
        }

        List<E> list= peekCollection(cuantity);//Using a previous method get the number of elements of the cuantity and gets the collection
        for(int i=0; i<cuantity;i++){
            poll();//and eliminates them of the list
        }
        return list;
    }

    @Override
    public List<E> pollLastCollection(int cuantity){//gets the last elements of the list and save them in a collection
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
    public boolean remove(E element){//remove an element in the list
        if(isEmpty()){
            return false;
        }
        LinkedNode<E> previous=null;//save the previos node 
        LinkedNode<E> n=head;//The node starts in the head

        while(n!=null && !n.get().equals(element) ){//moves forward until the node has the element whic we want to remove
            previous=n;
            n=n.getNext();

        }

        if(n==null){
            return false; //it means don't find the element to remove
        }
        if(n==head){
            if(size==1){
                clear();
            }else{
                head=head.getNext();//eliminates the head
                size--;
            }
            return true;
        }
        if(n==cola){//if the node we want to eliminates is the tail
            previous.setNext(null);//the previous element of the node will jump above the node to eliminate
            cola=previous;//the new tail is the previos
            size--;//decrease the size
            return true;
        }else{
            previous.setNext(n.getNext());//If the node we want to eliminate is in the middle of the list, the conections will skip the node we wants to eliminates
            size--;//decreace the size
        }

        return true;
    }

    @Override
    public boolean remove(E[] array){//For each element in the array it will remove in the list
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
    public boolean remove(Collection<E> collection){//For each element in the collection it will remove in the list
        if(isEmpty()){
            return false;
        }
        if(size<collection.size()){
            return false;
        }
        
        Iterator<E> iterator2 = collection.iterator();
        while(iterator2.hasNext()){
            E val=iterator2.next();
            while(remove(val)){
            }
        }
        return true;
    }

    @Override 
    public boolean remove(Predicate<E> filter){//It will remove all the elements whichs asserts with the filter
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
    public boolean replace(E element,E newElement, Predicate<E> comparator ){//Replace an element into the list
        if(comparator==null||element==null||newElement==null){
            return false;
        }
        if(isEmpty()){
            return false;
        }

        for(LinkedNode<E> node=head; node!=null; node=node.getNext()){
            if(node.get().equals(element)){
                if(comparator.test(node.get())){//If the comparator is true it will replace the element
                    node.set(newElement);
                    break;
                }
            }
            
        }
        return true;
    }

    @Override
    public boolean replace(E[] array, E[] newArray, Predicate<E> comparator){//Replace an array of element into the list
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
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator){//replace an collection of elements into the list
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
    public boolean set(E index, E element){//set an element in the position of the previous element
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
    public boolean retain(E[] array){//Only retain the elements who are into the array
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
            if(!found){//if the element isn't found into the array it element will be remove of the list
                remove(node.get());
            }
            node=next;
        }
        
        return true;
    }

    @Override
    public boolean retain(Collection<E> collection){//Only retain the elements who are into the collection
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
            if(!found){//if the element isn't found into the collection it element will be remove of the list
                remove(node.get());
            }
            node=next;
        }
        return true;
    }

    @Override
    public List<E> subList(E from, E to){//Creates a new list, between two elements, 

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
            if(node.get().equals(to) && !start){//if element to, appears before from it returns nothing, a empty list
                return list;
            }
            if(node.get().equals(from)){
                start=true;//if the element from appears it will start to add elements to the new list
            }
            if(start){
                list.add(node.get());//while start is true, each element will be added into the new list
            }
            if(node.get().equals(to)){//if we reach to element it will stop to add elements into the new list
                break;
            }
            node=node.getNext();
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray(){//It makes the list into an array
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
    public boolean sort(ToIntFunction<E> toInt){//sort all the elements of the list from smallest to largest
        if(toInt==null || size<2){
            return false;
        }

        Object[] array= toArray();//first it makes the list into an array, to sort it more easy

        for(int x=0;x<array.length-1;x++){
            for(int y=0;y<array.length-1-x;y++){

                int a=toInt.applyAsInt((E)array[y]);//Makes the element of the list into ints to compares it
                int b=toInt.applyAsInt((E)array[y+1]);

                if(a>b){
                    Object temporal=array[y];//saves the element who is bigger
                    array[y]=array[y+1];//changes the elements, from bigger,smaller to smaller,bigger
                    array[y+1]=temporal;
                }
            }
        }

        LinkedNode<E> node=head;
        int i=0;
        while(node!=null){
            node.set((E)array[i++]);
            node=node.getNext();//set all the elements of the new array
        }


        return true;

    }

    //Collection part
    @Override
    public int size(){
        return this.size;//returns the size of the list

    }
    @Override
    public boolean clear(){//clears the
        try{
            head=cola=null;
            size=0;
            return true;
        }catch(Exception e){
            return false;
        }
    } 

    @Override
    public boolean contains(E element){//verificates if the element is on the list
        for(LinkedNode<E> node=head; node!=null; node=node.getNext()){
            if(node.get().equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E[] array){//verficates if the all elements of the array is on the list
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
    public boolean contains(Collection<E> collection){//Verificates if all of the elements of the collection is on the list
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
    public boolean reverse(){//reverse the list
        if(isEmpty()||size<2){
            return false;
        }

        LinkedNode<E> current=head;//starts in the head
        LinkedNode<E> previous=null;

        LinkedNode<E> temp=cola;
        cola=head;//changes the cola with the head
        head=temp;

        while(current!=null){
            LinkedNode<E> next=current.getNext();//saves the next node
            current.setNext(previous);//the next node of the current node is the previos
            previous=current;//the previous node is now the current
            current=next;//and the current is now the next, because it moves forwards into the list
        }

        
        return true;
    }
     //Iterator part

    @Override
    public void forEach(Function<E,Void> action ){//The method forEach, means, for each node of the least it has to make an action
        if(isEmpty()){//Verificates if the list is empty
            return;
        }
        if(action==null){//Verficates if the action is null
            return;
        }

        for(LinkedNode<E> node=head; node!=null;node=node.getNext()){//Move forwards between nodes and makes the action for each node.
            action.apply(node.get());//here apply the action in the node.
        }
    }

    @Override
    public Iterator<E> iterator(){ //this method allow to return a iterator, for explore a list
        
        return new Iterator<E>(){ //Here we return the iterator, making it in a anonymous class.
            private LinkedNode<E> current=head;//The iterator starts in the head of the list


            @Override
            public boolean hasNext(){
                return current!=null; //if the node is different of null, it means, has next
            }

            @Override
            public E next(){
                if(!hasNext()){
                    throw new IllegalStateException("No more elements");//if don't have next, it generates a warn.
                }
                E element=current.get();//Saves the current element of the node
                current=current.getNext();//Move forward between nodes
                return element; //Return the element which was save before.
            }
        };
    }
}

package edu.uva.app.bintree.search;

import edu.uva.app.bintree.BinTree;
import edu.uva.app.bintree.Root;
import edu.uva.app.linkedlist.singly.singly.LinkedList;
import edu.uva.app.queue.list.Queue;
import edu.uva.model.iterator.Iterator;
import edu.uva.model.node.AbstractNode;
import edu.uva.model.tree.AbstractTree;
import edu.uva.model.tree.Tree;

public class BinSearchTree<E extends Comparable<E>> extends BinTree<E> {

    public BinSearchTree() {
        this.root = null;
        size=0;
    }

    public BinSearchTree(Root<E> root) {
        this.root=root;
        size=1;
    }

    @Override
    public boolean insert(E value){
        if(value==null){
            return false;
        }

        root=insertBinTree(root,value);
        return true;
    }

    private Root<E> insertBinTree(Root<E> root,E value){
        if(root==null){
            size++;
            return new Root<>(value);
        }
        if(value.compareTo(root.get())<0){
            root.setLeft(insertBinTree(root.getLeft(),value));
        }else if(value.compareTo(root.get())>0){
            root.setRight(insertBinTree(root.getRight(),value));
        }

        return root;
    }

    @Override
    public boolean search(E value){
        return searchBinSearch(root,value);
    }

    public boolean searchBinSearch(Root<E> root,E value){
        if(root==null){
            return false;
        }
        if(root.get().equals(value)){
            return true;
        }
        if(value.compareTo(root.get())<0){
            return searchBinSearch(root.getLeft(),value);
        }else{
            return searchBinSearch(root.getRight(),value);
        }
    }

    public int searchWithSteps(E value){
        return searchWithStepsRecursivo(root,value,0);
    }

    public int searchWithStepsRecursivo(Root<E> root, E value, int pasos){
        if(root==null){
            return -pasos;
        }
        pasos++;
        if(root.get().equals(value)){
            return pasos;
        }
        if(value.compareTo(root.get())<0){
            return searchWithStepsRecursivo(root.getLeft(),value,pasos);
        }else{
            return searchWithStepsRecursivo(root.getRight(),value,pasos);
        }

    }
    public void searchWithTime(E value){
        long inicio=System.nanoTime();

        int pasos= searchWithSteps(value);

        long fin=System.nanoTime();

        System.out.println("Pasos: "+ Math.abs(pasos));
        System.out.println("Tiempo de ejecución: "+(fin-inicio)+"s");
    }

    public void printTree(){
        printTreeAgain(root,"",true);
    }

    private void printTreeAgain(Root<E> root, String text, boolean isFinal){
        if(root==null){
            return;
        }
        System.out.println(text + (isFinal ? "-- " : "|-- ") + root.get());

        String newPrefix = text + (isFinal ? "    " : "|   ");

        if(root.getLeft()!=null||root.getRight()!=null){
            printTreeAgain(root.getLeft(),newPrefix,false);
            printTreeAgain(root.getRight(),newPrefix,false);
        }else if(root.getLeft()!=null){
            printTreeAgain(root.getLeft(),newPrefix,true);
        }else{
            printTreeAgain(root.getRight(),newPrefix,true);
        }
    }


}

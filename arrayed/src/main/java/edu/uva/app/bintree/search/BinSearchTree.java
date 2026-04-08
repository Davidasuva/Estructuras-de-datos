package edu.uva.app.bintree.search;

import edu.uva.app.bintree.BinTree;
import edu.uva.app.bintree.Root;
import edu.uva.app.linkedlist.singly.singly.LinkedList;
import edu.uva.app.queue.list.Queue;
import edu.uva.model.iterator.Iterator;
import edu.uva.model.node.AbstractNode;
import edu.uva.model.tree.AbstractTree;
import edu.uva.model.tree.Tree;

public class BinSearchTree<E> extends BinTree<E> {

    Root<Integer> root;

    public BinSearchTree() {
        this.root = null;
        size=0;
    }

    public boolean insert(int value) {
        Root<Integer> node=new Root<>(value);
        if(isEmpty()){
            this.root=node;
            size++;
            return true;
        }

        Queue<Root<Integer>> queue =new Queue<>();
        queue.insert(root);

        while(!queue.isEmpty()){
            Root<Integer> current=queue.extract();

            if(current.get()<node.get()){
                if(current.getLeft()==null){
                    current.setLeft(node);
                    size++;
                    return true;
                }else{
                    queue.insert(current.getLeft());
                }
            }
            if(current.get()>node.get()){
                if(current.getRight()==null){
                    current.setRight(node);
                    size++;
                    return true;
                }else{
                    queue.insert(current.getRight());
                }
            }
        }
        return false;
    }

    public boolean search(int value) {
        Tree<Integer> tree;
        Tree<Integer> tree2;
        if(isEmpty()){
            return false;
        }
        if(root.get().equals(value)){
            return true;
        }

        if(root.getLeft()!=null){
            tree=new BinTree<>(root.getLeft());
            if(root.getRight()!=null){
                tree2=new BinTree<>(root.getRight());
                return tree.search(value) || tree2.search(value);
            }else{
                return tree.search(value);
            }
        }else{
            if(root.getRight()!=null){
                tree2=new BinTree<>(root.getRight());
                return tree2.search(value);
            }else{
                return false;
            }
        }
    }
}

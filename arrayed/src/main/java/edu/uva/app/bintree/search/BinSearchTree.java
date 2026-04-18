package edu.uva.app.bintree.search;

import edu.uva.app.bintree.BinTree;
import edu.uva.app.bintree.Root;
import edu.uva.app.linkedlist.singly.singly.LinkedList;

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
    public boolean remove(E value){
        root=removeRecursive(root, value);
        return true;
    }


    public Root<E> removeRecursive(Root<E> root,E value){
        if(root==null){
            return null;
        }
        if(value.compareTo(root.get())<0){
            root.setLeft(removeRecursive(root.getLeft(),value));
        }else if(value.compareTo(root.get())>0){
            root.setRight(removeRecursive(root.getRight(),value));
        }else{
            if(root.getLeft()==null&&root.getRight()==null){
                return null;
            }
            if(root.getLeft()==null){
                return root.getRight();
            }
            if(root.getRight()==null){
                return root.getLeft();
            }

            Root<E> minRoot=findMin(root.getRight());
            root.set(minRoot.get());
            root.setRight(removeRecursive(root.getRight(),minRoot.get()));
        }
        return root;
    }

    private Root<E> findMin(Root<E> root){
        while(root.getLeft()!=null){
            root=root.getLeft();
        }
        return root;
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

    private boolean searchBinSearch(Root<E> root,E value){
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

    public LinkedList<E>  searchList(E value){
        return searchListRecursive(root,value);
    }

    private LinkedList<E> searchListRecursive(Root<E> root,E value){
        LinkedList<E> list=new LinkedList<>();
        if(root==null){
            return list;
        }
        list.add(root.get());
        if(root.get().equals(value)){
            return list;
        }
        if(value.compareTo(root.get())<0){
            list.add(searchListRecursive(root.getLeft(),value));
            return list;
        }else{
            list.add(searchListRecursive(root.getRight(),value));
            return list;
        }

    }

    public int searchWithSteps(E value){
        return searchWithStepsRecursivo(root,value,0);
    }

    private int searchWithStepsRecursivo(Root<E> root, E value, int pasos){
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
        System.out.println("Tiempo de ejecución: "+(fin-inicio)+"ns");
    }

    public LinkedList<E> searchByRange(E min, E max){
        return searchByRange2(root,min,max,new LinkedList<>());
    }
    public LinkedList<E> searchByRange2(Root<E> root, E min,E max, LinkedList<E> result){
        if(root==null){
            return null;
        }
        if(root.get().compareTo(min)>0){
            searchByRange2(root.getLeft(),min,max,result);
        }
        if(root.get().compareTo(max)<=0&&root.get().compareTo(min)>=0){
            result.add(root.get());
        }
        if(root.get().compareTo(max)<0){
            searchByRange2(root.getRight(),min,max,result);
        }
        return result;
    }

}

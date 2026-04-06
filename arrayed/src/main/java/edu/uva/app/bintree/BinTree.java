package edu.uva.app.bintree;
import edu.uva.app.linkedlist.singly.singly.LinkedList;
import edu.uva.app.queue.list.Queue;
import edu.uva.model.node.AbstractNode;
import edu.uva.model.tree.AbstractTree;
import edu.uva.model.tree.Tree;



public class BinTree<E> extends AbstractTree<E> {

    private Root<E> root;
    private int size;


    public BinTree(Root<E> root) {
        this.root = root;
        size=1;
    }

    public BinTree() {
        this.root = null;
        size=0;
    }


    @Override
    public boolean isComplete() {
        if(isEmpty()){
            return true;
        }
        if((root.getRight()!=null&&root.getLeft()!=null)){
            BinTree<E> leftTree=new BinTree<>(root.getLeft());
            BinTree<E> rightTree=new BinTree<>(root.getRight());
            if(leftTree.getHeight()==rightTree.getHeight()){
                return leftTree.isComplete() && rightTree.isComplete();
            }else{
                return false;
            }
        }
        return (root.getRight() == null && root.getLeft() == null);
    }

    @Override
    public boolean isFull() {
        if(isEmpty()){
            return true;
        }
        if((root.getRight()!=null&&root.getLeft()!=null)){
            BinTree<E> leftTree=new BinTree<>(root.getLeft());
            BinTree<E> rightTree=new BinTree<>(root.getRight());
            return leftTree.isFull() && rightTree.isFull();
        }
        return (root.getRight() == null && root.getLeft() == null);
    }

    @Override
    public double getlCIM() {
        return (double) getlCI() /size();
    }

    @Override
    public int getlCI() {
        int LCI=0;
        if(root==null){
            return 0;
        }
        Queue<Root<E>> queue= new Queue<>();
        queue.insert(root);
        Root<E> nextLevel=root.getLeft();
        LCI++;
        int nivel=2;

        while(!queue.isEmpty()){
            Root<E> current=queue.extract();

            if (current.equals(nextLevel)){
                nivel++;
                nextLevel=current.getLeft();
            }


            if(current.getLeft()!=null){
                queue.insert(current.getLeft());
                LCI+=nivel;

            }

            if(current.getRight()!=null){
                queue.insert(current.getRight());
                LCI+=nivel;
            }
        }

        return LCI;
    }

    @Override
    public Tree<E> getSubtree(AbstractNode<E> node) {
        if(isEmpty()){
            return null;
        }
        if(this.root.get().equals(node.get())){
            return new BinTree<>(this.root);
        }

        if(this.root.getLeft()!=null){
            Tree<E> tree=new BinTree<>(this.root.getLeft());
            Tree<E> found=tree.getSubtree(node);
            if(found!=null){
                return found;
            }

        }
        if(this.root.getRight()!=null){
            Tree<E> tree=new BinTree<>(this.root.getRight());
            Tree<E> found=tree.getSubtree(node);
            if(found!=null){
                return found;
            }
        }
        return null;
    }

    @Override
    public Tree<E> getRightSubtree(AbstractNode<E> root) {
        if(isEmpty()){
            return null;
        }
        if(this.root.get().equals(root.get())){
            return new BinTree<>(this.root.getRight());
        }

        if(this.root.getLeft()!=null){
            Tree<E> tree=new BinTree<>(this.root.getLeft());
            Tree<E> found=tree.getRightSubtree(root);
            if(found!=null){
                return found;
            }

        }
        if(this.root.getRight()!=null){
            Tree<E> tree=new BinTree<>(this.root.getRight());
            Tree<E> found=tree.getRightSubtree(root);
            if(found!=null){
                return found;
            }
        }
        return null;
    }

    @Override
    public Tree<E> getLeftSubtree(AbstractNode<E> root) {
        if(isEmpty()){
            return null;
        }
        if(this.root.get().equals(root.get())){
            return new BinTree<>(this.root.getLeft());
        }

        if(this.root.getLeft()!=null){
            Tree<E> tree=new BinTree<>(this.root.getLeft());
            Tree<E> found=tree.getLeftSubtree(root);
            if(found!=null){
                return found;
            }

        }
        if(this.root.getRight()!=null){
            Tree<E> tree=new BinTree<>(this.root.getRight());
            Tree<E> found=tree.getLeftSubtree(root);
            if(found!=null){
                return found;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int getGrade() {
        int grade=0;
        if(isEmpty()||(root.getLeft()==null&&root.getRight()==null)){
            return grade;
        }
        if(root.getLeft()!=null){
            grade++;

        }
        if(root.getRight()!=null){
            grade++;
        }
        BinTree<E> treeL=new BinTree<>(root.getLeft());
        BinTree<E> treeR=new BinTree<>(root.getRight());
        int gradeL=treeL.getGrade();
        int gradeR=treeR.getGrade();
        if(gradeL>grade){
            return gradeL;
        }else if(gradeR>gradeL){
            return gradeR;
        }
        return grade;
    }

    @Override
    public int getHeight() {
        int height=0;
        if(isEmpty()){
           return height;
        }
        height++;
        int height1=0;
        int height2=0;
        if(root.getLeft()!=null){
            Tree<E> tree=new BinTree<>(root.getLeft());
            height1=tree.getHeight();
        }
        if(root.getRight()!=null){
            Tree<E> tree=new BinTree<>(root.getRight());
            height2=tree.getHeight();
        }
        if(height1>height2){
            return height+height1;
        }else{
            return height+height2;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean search(E value) {
        Tree<E> tree;
        Tree<E> tree2;
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

    @Override
    public boolean remove(E value) {
        if(isEmpty()){
            return false;
        }
        Queue<Root<E>> queue=new Queue<>();
        queue.insert(root);
        Root<E> target=null;
        Root<E> last=null;
        Root<E> parentOfLast=null;
        while(!queue.isEmpty()){
            Root<E> current=queue.extract();

            if(current.get().equals(value)){
                target=current;
            }

            if(current.getLeft()!=null){
                parentOfLast=current;
                queue.insert(current.getLeft());
            }
            if(current.getRight()!=null){
                parentOfLast=current;
                queue.insert(current.getRight());
            }

            last=current;
        }
        if(target==null){
            return false;
        }

        if(last==root&&target==root){
            root=null;
            return true;
        }

        target.set(last.get());
        if(parentOfLast.getRight()==last){
            parentOfLast.setRight(null);
        }else{
            parentOfLast.setLeft(null);
        }
        return true;
    }

    @Override
    public boolean insert(E value) {
        Root<E> node=new Root<>(value);
        if(isEmpty()){
            this.root=node;
            size++;
            return true;
        }

        Queue<Root<E>> queue =new Queue<>();
        queue.insert(root);

        while(!queue.isEmpty()){
            Root<E> current=queue.extract();

            if(current.getLeft()==null){
                current.setLeft(node);
                size++;
                return true;
            }else{
                queue.insert(current.getLeft());
            }
            if(current.getRight()==null){
                current.setRight(node);
                size++;
                return true;
            }else{
                queue.insert(current.getRight());
            }
        }
        return false;
    }
    @Override
    public LinkedList<E> postorder() {
        LinkedList<E> list=new LinkedList<>();
        if(isEmpty()){
            return list;
        }
        if(root.getLeft()!=null){
            BinTree<E> tree=new BinTree<>(root.getLeft());
            list.add(tree.postorder());
        }
        if(root.getRight()!=null){
            BinTree<E> tree=new BinTree<>(root.getRight());
            list.add(tree.postorder());
        }
        list.add(root.get());

        return list;
    }

    @Override
    public LinkedList<E> inorder() {
        LinkedList<E> list=new LinkedList<>();
        if(isEmpty()){
            return list;
        }
        if(root.getLeft()!=null){
            BinTree<E> tree=new BinTree<>(root.getLeft());
            list.add(tree.inorder());
        }
        list.add(root.get());
        if(root.getRight()!=null){
            BinTree<E> tree=new BinTree<>(root.getRight());
            list.add(tree.inorder());
        }

        return list;
    }

    @Override
    public LinkedList<E> preorder() {
        LinkedList<E> list=new LinkedList<>();
        if(isEmpty()){
            return list;
        }

        list.add(root.get());
        if(root.getLeft()!=null){
            BinTree<E> tree=new BinTree<>(root.getLeft());
            list.add(tree.preorder());
        }
        if(root.getRight()!=null){
            BinTree<E> tree=new BinTree<>(root.getRight());
            list.add(tree.preorder());
        }
        return list;
    }
    @Override
    public LinkedList<E> levelOrder() {
        LinkedList<E> list= new LinkedList<>();
        if(root==null){
            return list;
        }
        Queue<Root<E>> queue= new Queue<>();
        queue.insert(root);

        while(!queue.isEmpty()){
            Root<E> current=queue.extract();
            list.add(current.get());

            if(current.getLeft()!=null){
                queue.insert(current.getLeft());
            }

            if(current.getRight()!=null){
                queue.insert(current.getRight());
            }
        }
        return list;
    }
}

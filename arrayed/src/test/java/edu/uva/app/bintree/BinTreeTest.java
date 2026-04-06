package edu.uva.app.bintree;

import edu.uva.app.linkedlist.singly.singly.LinkedList;
import org.junit.jupiter.api.Test;
import edu.uva.model.tree.Tree;

import static org.junit.jupiter.api.Assertions.*;

class BinTreeTest {

    @Test
    void isComplete() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.isComplete());
    }

    @Test
    void isFull() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        assertTrue(binTree.insert("i"));
        assertTrue(binTree.isFull());
    }

    @Test
    void getlCIM() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        assertTrue(binTree.insert("i"));
        System.out.println(binTree.getlCIM());
    }

    @Test
    void getlCI() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        assertTrue(binTree.insert("i"));
        System.out.println(binTree.getlCI());
    }

    @Test
    void getSubtree() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        Root<String> g=new Root<>("g");
        Tree<String> subTree =binTree.getSubtree(g);
        LinkedList<String> list = (LinkedList<String>) subTree.levelOrder();
        System.out.println(list.toString());

    }

    @Test
    void getRightSubtree() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        assertTrue(binTree.insert("i"));
        Root<String> d=new Root<>("d");
        Root<String> i=new Root<>("i");
        d.setRight(i);
        Tree<String> subTree =binTree.getRightSubtree(d);
        LinkedList<String> list = (LinkedList<String>) subTree.levelOrder();
        System.out.println(list.toString());
    }

    @Test
    void getLeftSubtree() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        Root<String> d=new Root<>("d");
        Root<String> h=new Root<>("h");
        d.setLeft(h);
        Tree<String> subTree =binTree.getLeftSubtree(d);
        LinkedList<String> list = (LinkedList<String>) subTree.levelOrder();
        System.out.println(list.toString());
    }

    @Test
    void isEmpty() {
    }

    @Test
    void getGrade() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        System.out.println(binTree.getGrade());
    }

    @Test
    void getHeight() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        System.out.println(binTree.getHeight());
    }

    @Test
    void size() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        System.out.println(binTree.size());
    }

    @Test
    void search() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        System.out.println(binTree.search("c"));
    }

    @Test
    void remove() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        LinkedList<String> list = binTree.levelOrder();
        System.out.println(list.toString());
        assertTrue(binTree.remove("c"));
        LinkedList<String> list2 = binTree.levelOrder();
        System.out.println(list2.toString());
    }

    @Test
    void insert() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        LinkedList<String> list = binTree.inorder();
        System.out.println(list.toString());
    }

    @Test
    void postorder() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        LinkedList<String> list = binTree.postorder();
        System.out.println(list.toString());
    }

    @Test
    void inorder() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        LinkedList<String> list = binTree.inorder();
        System.out.println(list.toString());
    }

    @Test
    void preorder() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        LinkedList<String> list = binTree.preorder();
        System.out.println(list.toString());
    }

    @Test
    void levelOrder() {
        BinTree<String> binTree = new BinTree<>();
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        LinkedList<String> list = binTree.levelOrder();
        System.out.println(list.toString());
    }
}
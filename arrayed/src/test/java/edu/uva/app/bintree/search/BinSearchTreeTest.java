package edu.uva.app.bintree.search;

import edu.uva.app.bintree.BinTree;
import edu.uva.app.linkedlist.singly.singly.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinSearchTreeTest {

    @Test
    void insert() {
        BinSearchTree<String> binTree = new BinSearchTree<>();
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        binTree.printTree();
    }

    @Test
    void search() {
        BinSearchTree<String> binTree = new BinSearchTree<>();
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        binTree.search("g");
    }

    @Test
    void searchWithTime() {
        BinSearchTree<String> binTree = new BinSearchTree<>();
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        binTree.searchWithTime("g");
    }

    @Test
    void searchList() {
        BinSearchTree<String> binTree = new BinSearchTree<>();
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        LinkedList<String> list=binTree.searchList("g");
        System.out.println(list.toString());
        binTree.printTree();
    }

    @Test
    void remove() {
        BinSearchTree<String> binTree = new BinSearchTree<>();
        assertTrue(binTree.insert("c"));
        assertTrue(binTree.insert("b"));
        assertTrue(binTree.insert("d"));
        assertTrue(binTree.insert("a"));
        assertTrue(binTree.insert("e"));
        assertTrue(binTree.insert("f"));
        assertTrue(binTree.insert("g"));
        assertTrue(binTree.insert("h"));
        assertTrue(binTree.insert("h"));
        binTree.printTree();
        binTree.remove("c");
        binTree.printTree();
    }

    @Test
    void searchByRange() {
        BinSearchTree<Integer> binTree = new BinSearchTree<>();
        assertTrue(binTree.insert(2));
        assertTrue(binTree.insert(3));
        assertTrue(binTree.insert(1));
        assertTrue(binTree.insert(4));
        assertTrue(binTree.insert(5));
        assertTrue(binTree.insert(6));
        assertTrue(binTree.insert(7));
        assertTrue(binTree.insert(8));
        assertTrue(binTree.insert(9));
        binTree.printTree();
        LinkedList<Integer> list=new LinkedList<>();
        System.out.println(binTree.searchByRange(3,7).toString());
    }
}
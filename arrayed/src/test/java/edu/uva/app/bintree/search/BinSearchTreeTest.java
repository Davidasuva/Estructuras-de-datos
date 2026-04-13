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
}
package edu.uva.app.bintree.search;

import edu.uva.app.bintree.BinTree;
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
}
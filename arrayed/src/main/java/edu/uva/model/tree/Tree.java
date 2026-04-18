package edu.uva.model.tree;
import edu.uva.model.list.List;
import edu.uva.model.node.AbstractNode;

public interface Tree<E> {

    List<E> preorder();
    List<E> inorder();
    List<E> postorder();
    List<E> levelOrder();
    boolean insert(E value);
    boolean remove(E value);

    boolean search(E value);
    int size();

    int getHeight();
    int getGrade();
    boolean isEmpty();
    Tree<E> getLeftSubtree(AbstractNode<E> root);
    Tree<E> getRightSubtree(AbstractNode<E> root);

    Tree<E> getSubtree(AbstractNode<E> root);
    int getlCI();
    double getlCIM();
    boolean isFull();
    boolean isComplete();
    boolean isEquilibrated();
    int equilibrated();



}

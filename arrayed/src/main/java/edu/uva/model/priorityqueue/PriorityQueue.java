package edu.uva.model.priorityqueue;
import edu.uva.model.queue.Queue;

public interface PriorityQueue<E> extends Queue<E>{

    boolean insert(E element);

    boolean insert(int index, E element);
}

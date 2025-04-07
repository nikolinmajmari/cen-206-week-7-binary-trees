package tree.iterators;

import tree.Node;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.SynchronousQueue;

public class LevelOrderIterator<T> implements Iterator<T> {
    private Node<T> root;
    private Queue<Node<T>> queue;
    LevelOrderIterator(Node<T> root) {
        this.root = root;
        this.queue = new ConcurrentLinkedQueue<>();
        this.queue.add(root);
    }

    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }

    @Override
    public T next() {
        Node<T> node = this.queue.poll();
        this.queue.add(node.left);
        this.queue.add(node.right);
        return node.data;
    }
}

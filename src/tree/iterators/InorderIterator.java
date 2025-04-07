package tree.iterators;

import tree.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class InorderIterator<T> implements Iterator<T> {
    private Node<T> root;
    private Queue<T> queue;
    public InorderIterator(Node<T> root) {
        this.root = root;
        this.queue = new ConcurrentLinkedQueue<T>();
        this.queue.addAll(visitInorder(root));
    }

    List<T> visitInorder(Node<T> root){
        List<T> result = new ArrayList<>();
        if(root.left!=null){
            result.addAll(visitInorder(root.left));
        }
        result.add(root.data);
        if(root.right!=null){
            result.addAll(visitInorder(root.right));
        }
        return result;
    }


    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }

    @Override
    public T next() {
        return this.queue.poll();
    }
}

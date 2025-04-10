package tree;

public class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;
    public int balanceFactor;

    public Node(T data) {
        this.data = data;
    }
}

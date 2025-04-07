package tree;

public class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;
    public int balanceFactor;
    public int height;
    public Node(T data) {
        this.data = data;
    }
}

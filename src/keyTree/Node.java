package keyTree;

public class Node<K,V> {
    public K key;
    public V value;
    public Node<K,V> left;
    public Node<K,V> right;
    public Node(K key) {
        this.key = key;
        this.value = value;
    }
}

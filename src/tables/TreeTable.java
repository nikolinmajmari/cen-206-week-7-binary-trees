package tables;

import java.lang.ref.PhantomReference;

public class TreeTable<K extends Comparable<K>,V> implements TableInterface<K,V>{

    Node<K,V> root;

    TreeTable(){
        root = null;
    }
    TreeTable(Node<K,V> root){
        this.root = root;
    }

    @Override
    public V get(K key) {
        return get(root,key);
    }

    private V get(Node<K,V> node,K key){
        if(node == null){
            return null;
        }
        if(key.equals(node.key)){
            return node.value;
        }
        if(key.compareTo(node.key) < 0){
            return get(node.left,key);
        }
        if(key.compareTo(node.key) > 0){
            return get(node.right,key);
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        root = put(root,key,value);
    }

    public Node<K,V> put(Node<K,V> node,K key,V value){
        if(node == null){
            return new Node<>(key,value);
        }
        if(key.equals(node.key)){
            node.value = value;
        }
        if(key.compareTo(node.key) < 0){
            node.left = put(node.left,key,value);
        }
        if(key.compareTo(node.key) > 0){
            node.right = put(node.right,key,value);
        }
        return node;
    }

    @Override
    public void remove(K key) {
        root = remove(root,key);
    }

    private Node<K,V> remove(Node<K,V> node,K key){
        if(node == null){
            return null;
        }
        if(key.equals(node.key)){
            if(node.left == null){
                return node.right;
            }
            if(node.right == null){
                return node.left;
            }
            Node<K,V> leftMax = max(node.left);
            node.key = leftMax.key;
            node.value = leftMax.value;
            node.left = remove(node.left, leftMax.key);
            return node;
        }
        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
        }
        if(key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
        }
        return node;
    }
    private Node<K,V> max(Node<K,V> node){
        if(node == null){
            return null;
        }
        if(node.right == null){
            return node;
        }
        return max(node.right);
    }
}

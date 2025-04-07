package tree;

import java.util.Iterator;

import static java.lang.Long.MAX_VALUE;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> root;
    BinarySearchTree(){}
    BinarySearchTree(Node<T> root) {
        this.root = root;
    }
    public void insert(T value) {
        root = insert(root,value);
    }
    private Node<T> insert(Node<T> root, T value) {
        if (root == null) {
            return new Node<>(value);
        }
        if (root.data.compareTo(value) < 0) {
            root.right = insert(root.right,value);
        }
        else if (root.data.compareTo(value) > 0) {
            root.left = insert(root.left,value);
        }
        return root;
    }
    public void insert(Node<T> node){
        root = insert(root,node);
    }
    private Node<T> insert(Node<T> root, Node<T> node){
        if (root == null) {
            return node;
        }
        if (root.data.compareTo(node.data) < 0) {
            root.right = insert(root.right,node);
        }
        else if (root.data.compareTo(node.data) > 0) {
            root.left = insert(root.left,node);
        }
        return root;
    }

    public boolean isValid() {
        return isValid(root);
    }

    private boolean isValid(Node<T> root) {

        return false;
    }
    public boolean containsIteratively(T value) {
       return false;
    }
    public boolean contains(T value) {
        return false;
    }
    public boolean contains(Node<T> root, T value) {
        return false;
    }

    public T min(){
        return min(root);
    }
    private T min(Node<T> root){

        return root.data;
    }
    public T max(){
        return max(root);
    }
    private T max(Node<T> root){

        return max(root);
    }

    public void remove(T value) {
        root = remove(root,value);
    }
    private Node<T> remove(Node<T> root, T value) {
        return null;
    }

    public int distance(T left, T right) {
       return 0;
    }

    public void calculateHeight(Node <T> root) {
        ///
    }
    public int height(Node<T> root){
        return 0;
    }

    public int rootBalanceFactor(){
        root.balanceFactor =  height(root.left) - height(root.right);
        return root.balanceFactor;
    }

    public void calculateBalanceFactor(Node<T> root){
       ///
        return;
    }

    public void calculateAllBalanceFactors(){
        //
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

package tree;

import tree.iterators.InorderIterator;

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
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if(root.left!=null && max(root.left).compareTo(root.data)>0){
            return false;
        }
        if(root.right!=null && min(root.right).compareTo(root.data)<0){
            return false;
        }
        return isValid(root.left) && isValid(root.right);
    }

    public boolean contains(T value) {
        return contains(root,value);
    }
    public boolean contains(Node<T> root, T value) {
        if (root == null) {
            return false;
        }
        if (root.data.equals(value)) {
            return true;
        }
        if (root.data.compareTo(value) < 0) {
            return contains(root.right,value);
        }
        else if (root.data.compareTo(value) > 0) {
            return contains(root.left,value);
        }
        return false;
    }

    public T min(){
        return min(root);
    }
    private T min(Node<T> root){
        if(root==null){
            return null;
        }
        if(root.left==null){
            return root.data;
        }
        return min(root.left);
    }
    public T max(){
        return max(root);
    }
    private T max(Node<T> root){
        if(root==null){
            return null;
        }
        if(root.right==null){
            return root.data;
        }
        return max(root.right);
    }

    public void remove(T value) {

    }
    private Node<T> remove(Node<T> root, T value) {
        if(root == null){
            return null;
        }
        if(value.compareTo(root.data) < 0){
            root.left = remove(root.left,value);
        }else if(value.compareTo(root.data) > 0){
            root.right = remove(root.right,value);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }else{
                root.data = min(root.right);
                root.right = remove(root.right,root.data);
            }
        }
        return root;
    }

    public int distance(T left, T right) {
       return distance(root, left, right);
    }

    public int distance(Node<T> root, T left, T right) {
        if(root == null){
            return 0;
        }
        if(root.data.compareTo(left) > 0 && root.data.compareTo(right) > 0){
            return distance(root.left,left,right);
        }else if(root.data.compareTo(left) < 0 && root.data.compareTo(right) < 0){
            return distance(root.right,left,right);
        }else{
            int l = find(root, left);
            int r = find(root, right);
            return l + r;
        }
    }

    public int find(Node<T> root, T value) {
        if(root == null || root.data.equals(value)){
            return 0;
        }
        if(value.compareTo(root.data) < 0){
            return 1 + find(root.left,value);
        }else {
            return 1 + find(root.right,value);
        }
    }

    public int height(Node<T> root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        root.balanceFactor = leftHeight - rightHeight;
        return 1+Math.max(leftHeight, rightHeight);
    }

    public int rootBalanceFactor(){
        root.balanceFactor =  height(root.left) - height(root.right);
        return root.balanceFactor;
    }

    public void calculateBalanceFactor(Node<T> root){
       root.balanceFactor =  height(root.left) - height(root.right);
       calculateBalanceFactor(root.left);
       calculateBalanceFactor(root.right);
    }



    @Override
    public Iterator<T> iterator() {
        return new InorderIterator(root);
    }
}

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
        if (root != null) {
            if (root.data.equals(value)) {
                if(root.left==null){
                    return root.right;
                } else if (root.right==null) {
                    return root.left;
                }else{
                    root.data = min(root.right);
                    root.right = remove(root.right,root.data);
                }
            } else if (root.data.compareTo(value) < 0) {
                root.left = remove(root.left,value);
            }else{
                root.right = remove(root.right,value);
            }
        }
        return root;
    }

    public int distance(T left, T right) {
        return 0;
    }

    public int rootBalanceFactor(){
        return 0;
    }

    public void calculateAllBalanceFactors(){
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

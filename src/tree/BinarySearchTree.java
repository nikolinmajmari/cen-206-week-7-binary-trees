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
        Node<T>current = root;
        if(current==null){
            return false;
        }
        while(current!=null){
            if(current.data.equals(value)){
                return true;
            }
            if(current.data.compareTo(value)<0){
                current = current.right;
            }
            else if(current.data.compareTo(value)>0){
                current = current.left;
            }
        }
        return false;
    }
    public boolean contains(T value) {
        return contains(root,value);
    }
    public boolean contains(Node<T> root, T value) {
        if(root==null){
            return false;
        }
        if(root.data.equals(value)){
            return true;
        }
        if(root.data.compareTo(value)<0){
            return contains(root.right,value);
        }
        if(root.data.compareTo(value)>0){
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
        while(root.left!=null){
            root = root.left;
        }
        return root.data;
    }
    public T max(){
        return max(root);
    }
    private T max(Node<T> root){
        if(root==null){
            return null;
        }
        if(root.right == null){
            return root.data;
        }
        return max(root.right);
    }

    public void remove(T value) {
        root = remove(root,value);
    }
    private Node<T> remove(Node<T> root, T value) {
        if(root==null){
            return null;
        }
        if(!root.data.equals(value) ){
            if(root.data.compareTo(value) < 0){
                root.right = remove(root.right,value);
            }
            if(root.data.compareTo(value) > 0){
                root.left = remove(root.left,value);
            }
            return root;
        }
        if(root.data.equals(value)) {
            if (root.left == null && root.left == null) {
                return null;

            }
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }
            root.data = min(root.right);
            root.right = remove(root.right,root.data);
            return root;

        }
        return root;
    }

    public int distance(T left, T right) {
        if(left.compareTo(right) > 0){
            return distance(right, left);
        }
        Node<T> closestCommonAncestor = closestCommonAncestor(root,left,right);

        int distance = hops(closestCommonAncestor, left) + hops(closestCommonAncestor, right);

        return distance;
    }

    public Node<T> closestCommonAncestor(Node<T> root, T left, T right) {
        if(root == null) {
            return null;
        }

        if(root.data.compareTo(left) > 0 && root.data.compareTo(right) < 0) {
            return root;
        }
        if(root.data.compareTo(right) > 0 && root.data.compareTo(left) > 0) {
            return closestCommonAncestor(root.left, left, right);
        }
        if(root.data.compareTo(right) < 0 && root.data.compareTo(left) < 0) {
            return closestCommonAncestor(root.right, left, right);
        }

        return null;
    }

    public int hops(Node<T> root, T value) {
        if(root==null){
            return 0;
        }

        int counter = 0;
        while(root != null) {
            if(root.data.equals(value)){
                return counter;
            }
            if(root.data.compareTo(value)<0){
                root = root.right;
                counter++;
            }
            if(root.data.compareTo(value)>0){
                root = root.left;
                counter++;
            }
        }

        return -1;
    }

    public void calculateHeight(Node <T> root) {
        if(root == null){
            return;
        }
        calculateHeight(root.left);
        calculateHeight(root.right);
        if(root.left==null && root.right==null){
            root.height = 1;
        }else if(root.left==null){
            root.height = root.right.height+1;
        }else if(root.right==null){
            root.height = root.left.height+1;
        }else{
            root.height = Math.max(root.left.height+1,root.right.height+1);
        }
    }
    public int height(Node<T> root){
        if(root==null){
            return 0;
        }
        return 1 + Math.max(height(root.left),height(root.right));
    }

    public int rootBalanceFactor(){
        root.balanceFactor =  height(root.left) - height(root.right);
        return root.balanceFactor;
    }

    public void calculateBalanceFactor(Node<T> root){
        if(root==null){
            return;
        }
        root.balanceFactor = root.left.height - root.right.height;
        calculateBalanceFactor(root.left);
        calculateBalanceFactor(root.right);
    }

    public void calculateAllBalanceFactors(){
        calculateHeight(root);
        calculateBalanceFactor(root);
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

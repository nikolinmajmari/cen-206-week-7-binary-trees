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
    boolean result = true;

    if (root.left != null) {
        result = result && isValid(root.left);
        T maxValue = max(root.left);
        result = result && root.data.compareTo(maxValue) > 0;
    }
    if (root.right != null) {
        result = result && isValid(root.right);
        T minValue = min(root.right);
        result = result && root.data.compareTo(minValue) < 0;
    }
    return result;
    }
    public boolean containsIteratively(T value) {
       return false;
    }
    public boolean contains(T value) {

        return contains(root,value);

    }
    public boolean contains(Node<T> root, T value) {
        if(root == null) {
            return false;
        }
    if(root.data.equals(value)) {
        return true;
    }
      if(root.data.compareTo(value) > 0) {
          return contains(root.right,value);
      }
      else if(root.data.compareTo(value) < 0) {
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
Node <T> current=root;
while(current.left!=null){
    current=current.left;
}
return current.data;
    }
    public T max(){
        return max(root);
    }
    private T max(Node<T> root){
    if(root==null){
        return null;
    }
    Node <T> current=root;
    while(current.right!=null){
        current=current.right;
    }
        return current.data;
    }

    public void remove(T value) {
        root = remove(root,value);
    }
    private Node<T> remove(Node<T> root, T value) {
        if(root == null) {
            return null;
        }
        if(!root.data.equals(value)) {
            if (root.data.compareTo(value) < 0) {
                root.right = remove(root.right,value);
            } else if (root.data.compareTo(value) > 0) {
                root.left = remove(root.left,value);
            }
            return root;
        }else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            root.data = max(root.left);
            root.left=remove(root.left,root.data);
            return root;
        }
    }

    public int distance(T left, T right) {
        Node<T> ancestor = closestCommonAncestor(root, left, right);
        return steps(ancestor, left) + steps(ancestor, right);
    }

    public int steps(Node<T> root, T value) {
        if(root == null) {
            return 0;
        } else if(root.data.equals(value)) {
            return 1;
        } else if(root.data.compareTo(value) < 0) {
            return 1 + steps(root.right,value);
        } else {
            return 1 + steps(root.left,value);
        }
    }

    public Node<T> closestCommonAncestor(Node<T> root, T right, T left) {
        if(root == null) {
            return null;
        }
        if(right.compareTo(root.data) > 0 && left.compareTo(root.data) < 0) {
            return root;
        }
        if(right.compareTo(root.data) < 0 && left.compareTo(root.data) < 0) {
            return closestCommonAncestor(root.left,right,left);
        } else if(right.compareTo(root.data) > 0 && left.compareTo(root.data) > 0) {
            return closestCommonAncestor(root.right,right,left);
        }
        return null;
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
       if(root == null){
           return ;
       }
       root.balanceFactor =  height(root.left) - height(root.right);
       calculateBalanceFactor(root.left);
       calculateBalanceFactor(root.right);
    }

    public void calculateAllBalanceFactors(){
        //
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

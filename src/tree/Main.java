package tree;

public class Main {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(100);
        root.left = new Node<>(50);
        root.right = new Node<>(150);
        root.left.left = new Node<>(25);
        root.left.right = new Node<>(75);
        root.right.left = new Node<>(125);
        root.right.right = new Node<>(175);
        root.left.left.left = new Node<>(11);
        root.left.left.right = new Node<>(35);

        BinarySearchTree<Integer> bst = new BinarySearchTree<>(root);

        System.out.printf("It contains 125 %b\n", bst.contains(125));
        System.out.printf("before inserting 55 %b\n",bst.contains(55));
        bst.insert(55);
        System.out.printf("after inserting 55 %b\n",bst.contains(55));
        System.out.printf("Bst is valid = %b\n",bst.isValid());
    }
}

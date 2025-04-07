package keyTree.indexes;

import keyTree.Node;
import keyTree.Student;

import java.util.List;

public class AgeBST {
    Node<Integer, List<Student>> root;

    public void insert(Student s) {
        root = insert(root, s);
    }
    private Node<Integer, List<Student>> insert(
            Node<Integer, List<Student>> root, Student s) {
        if (root == null) {
            return new  Node<>(s.getAge())                     ;
        }
        if (root.key.compareTo(s.getAge()) < 0) {
            root.left = insert(root.left, s);
        }
        if (root.key.compareTo(s.getAge()) > 0) {
            root.right = insert(root.right, s);
        }
        root.value.add(s);
        return root;
    }


    public List<Student> search(int age){
        return null;
    }
}

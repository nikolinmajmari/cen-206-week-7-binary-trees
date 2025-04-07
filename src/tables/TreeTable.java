package tables;

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
        return null;
    }

    public Node<K,V> put(Node<K,V> root,K key,V value){
        if(root == null){
            return new Node<>(key,value);
        }

        if(root.key.equals(key)){
            root.value = value;
        } else if(root.key.compareTo(key) < 0){
            root.right = put(root.right,key,value);
        } else{
            root.left = put(root.left,key,value);
        }
        return root;
    }
    @Override
    public void put(K key, V value) {

        root = put(root,key,value);

    }

    @Override
    public void remove(K key) {

    }
}

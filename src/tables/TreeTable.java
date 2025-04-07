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

    @Override
    public void put(K key, V value) {

    }

    @Override
    public void remove(K key) {

    }
}

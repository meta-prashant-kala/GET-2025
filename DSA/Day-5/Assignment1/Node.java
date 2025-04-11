public class Node <K extends Comparable<K>,V>{
    private Pair<K, V> data;
    private Node<K, V> leftNode;
    private Node<K, V> rightNode;

    public Node(K key, V value){
        data.setKey(key);
        data.setValue(value);
        leftNode=null;
        rightNode=null;
    }

    public Pair<K, V> getData() {
        return data;
    }

    public Node<K, V> getLeftNode() {
        return leftNode;
    }

    public Node<K, V> getRightNode() {
        return rightNode;
    }
    public void setLeftNode(Node<K,V> leftNode) {
        this.leftNode=leftNode;
    }

    public void setRightNode(Node<K,V> rightNode) {
        this.rightNode=rightNode;
    }
}

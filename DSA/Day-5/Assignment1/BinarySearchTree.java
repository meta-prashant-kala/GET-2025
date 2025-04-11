
public class BinarySearchTree<K extends Comparable<K>, V> implements Dictionary<K,V> {
    Node<K, V> rootNode;

    public BinarySearchTree() {
        rootNode = null;
    }

    public boolean addValue(Pair<K, V> pairObj) {
        Node<K, V> nodeObj = new Node<K, V>(pairObj.getKey(), pairObj.getValue());
        if (rootNode == null) {
            rootNode = nodeObj;
        } else {
            Node<K, V> tempNode = rootNode;
            while (tempNode != null && (tempNode.getLeftNode() != null || tempNode.getRightNode() != null)) {
                if (tempNode.getData().getKey().compareTo(rootNode.getData().getKey()) > 0) {
                    tempNode = tempNode.getLeftNode();
                } else if (tempNode.getData().getKey().compareTo(rootNode.getData().getKey()) < 0) {
                    tempNode = tempNode.getRightNode();
                } else {
                    return false;
                }
            }
            if (tempNode.getData().getKey().compareTo(rootNode.getData().getKey()) < 0) {
                tempNode.setLeftNode(tempNode);
            } else if (tempNode.getData().getKey().compareTo(rootNode.getData().getKey()) > 0) {
                tempNode.setRightNode(nodeObj);
            } else {
                return false;
            }
        }
        return true;
    }

    public Node<K, V> deleteNode(Node<K, V> treeNodeIterator) {
        if(treeNodeIterator.getLeftNode()==null && treeNodeIterator.getRightNode()==null){
            return null;
        }
        if(treeNodeIterator.getLeftNode()==null){
            return treeNodeIterator.getRightNode();
        }
        if(treeNodeIterator.getRightNode()==null){
            return treeNodeIterator.getLeftNode();
        }
        Node<K, V> leftTreeRoot = treeNodeIterator.getLeftNode();
        Node<K, V> rightTreeRoot = treeNodeIterator.getLeftNode();
        Node<K, V> leftTreeRightestLeaf = treeNodeIterator.getRightNode();
        while (leftTreeRightestLeaf.getRightNode() != null) {
            leftTreeRightestLeaf = leftTreeRightestLeaf.getRightNode();
        }
        treeNodeIterator.setLeftNode(null);
        treeNodeIterator.setRightNode(null);
        leftTreeRightestLeaf.setRightNode(rightTreeRoot);
        return leftTreeRoot;
    }

    public void deleteValue(K key) {
        Node<K, V> treeIterator = rootNode;
        // if (treeIterator.getLeftNode().getData().getKey().equals(key)
        //         && treeIterator.getLeftNode().getRightNode() == null) {
        //     treeIterator.setLeftNode(treeIterator.getLeftNode());
        // }
        while (treeIterator != null) {
            if (treeIterator.getLeftNode().getData().getKey().compareTo(key) == 0) {
                treeIterator.setLeftNode(deleteNode(treeIterator.getLeftNode()));
            } else if (treeIterator.getRightNode().getData().getKey().compareTo(key) == 0) {
                treeIterator.setRightNode(treeIterator.getRightNode());

            } else {
                if (treeIterator.getData().getKey().compareTo(key) < 0) {
                    treeIterator = treeIterator.getLeftNode();
                } else if (treeIterator.getData().getKey().compareTo(key) > 0) {
                    treeIterator = treeIterator.getRightNode();
                }
            }
        }
    }

    public V getValue(K key) {
        Node<K, V> tempNode = rootNode;
        while (tempNode != null && (tempNode.getLeftNode() != null || tempNode.getRightNode() != null)) {
            if (tempNode.getData().getKey().compareTo(rootNode.getData().getKey()) > 0) {
                tempNode = tempNode.getLeftNode();
            } else if (tempNode.getData().getKey().compareTo(rootNode.getData().getKey()) < 0) {
                tempNode = tempNode.getRightNode();
            } else if (tempNode.getData().getKey().compareTo(rootNode.getData().getKey()) == 0) {
                return tempNode.getData().getValue();
            }
        }
        if (tempNode.getData().getKey().compareTo(rootNode.getData().getKey()) == 0) {
            return tempNode.getData().getValue();
        }
        return null;
    }

    // public getSortedList

}

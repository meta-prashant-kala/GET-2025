import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<K extends Comparable<K>, V> implements Dictionary<K, V> {
    Node<K, V> rootNode;

    /**
     * Constructor to initial the binary search tree with initial json value
     * 
     * @param json should be of String type
     */
    public BinarySearchTree(String json) {
        createInitialTree(json);
    }

    /**
     * Constructor to initial the binary search tree
     */
    public BinarySearchTree() {
        rootNode = null;
    }

    /**
     * Mehtod to parse the json String.
     * The method starts with removing the brackets then create array by seperating
     * the string with ','. The string array conatines key value pair at every
     * index, then split the key value string at every index by ':'. Now the array
     * contains key at 0th index and value at 1st index. Then the method tries to
     * parse it to int if it is succesfully parsed then stored as list otherwise as
     * a string
     * 
     * @param json should be of string type
     */
    public void createInitialTree(String json) {
        int intKey;
        json = json.replace('{', ' ');
        json = json.replace('}', ' ');
        json = json.replace('[', ' ');
        json = json.replace(']', ' ');
        String[] pairTypeList = json.split(",");
        for (String keyValuePairString : pairTypeList) {
            String[] keyValuePairList = keyValuePairString.split(":");
            String key = keyValuePairList[0].trim();
            String value = (keyValuePairList[1]).trim();
            if (key.matches("^\\d+$")) {
                intKey = Integer.parseInt(key);
                addValue(new Pair(intKey, value));
            } else {
                addValue(new Pair(key, value));
            }
        }
    }

    /**
     * Getter method to get the root node
     * 
     * @return root node of the tree
     */
    public Node<K, V> getRootNode() {
        return rootNode;
    }

    /**
     * Method to add a key value pair to the binary search tree class
     * 
     * @return trur if the value added sucessfully, otherwise false
     */
    public boolean addValue(Pair<K, V> pairObj) {
        Node<K, V> nodeObj = new Node<K, V>(pairObj.getKey(), pairObj.getValue());
        if (rootNode == null) {
            rootNode = nodeObj;
        } else {
            Node<K, V> tempNode = rootNode;
            while (tempNode != null && (tempNode.getLeftNode() != null || tempNode.getRightNode() != null)) {
                if (tempNode.getLeftNode() != null && pairObj.compareTo(tempNode.getData()) < 0) {
                    tempNode = tempNode.getLeftNode();
                } else if (tempNode.getRightNode() != null && pairObj.compareTo(tempNode.getData()) > 0) {
                    tempNode = tempNode.getRightNode();
                } else {
                    break;
                }
            }
            if (pairObj.compareTo(tempNode.getData()) < 0) {
                tempNode.setLeftNode(nodeObj);
            } else if (pairObj.compareTo(tempNode.getData()) > 0) {
                tempNode.setRightNode(nodeObj);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method to deleteValue method that delete a node form the binary search
     * tree
     * 
     * @param treeNodeIterator shuould be of Node type
     * @return next node after deleting the node
     */
    public Node<K, V> deleteNode(Node<K, V> treeNodeIterator) {
        if (treeNodeIterator.getLeftNode() == null && treeNodeIterator.getRightNode() == null) {
            return null;
        }
        if (treeNodeIterator.getLeftNode() == null) {
            return treeNodeIterator.getRightNode();
        }
        if (treeNodeIterator.getRightNode() == null) {
            return treeNodeIterator.getLeftNode();
        }
        Node<K, V> leftTreeRoot = treeNodeIterator.getLeftNode();
        Node<K, V> rightTreeRoot = treeNodeIterator.getRightNode();
        Node<K, V> leftTreeRightestLeaf = treeNodeIterator.getLeftNode();
        while (leftTreeRightestLeaf.getRightNode() != null) {
            leftTreeRightestLeaf = leftTreeRightestLeaf.getRightNode();
        }
        treeNodeIterator.setLeftNode(null);
        treeNodeIterator.setRightNode(null);
        leftTreeRightestLeaf.setRightNode(rightTreeRoot);
        return leftTreeRoot;
    }

    /**
     * Method to delete a value from the that corrosponds to the input key
     * 
     * @param key whose value would be deleted
     * @return true if the key deleted succesfully, otherwise false
     */
    public boolean deleteValue(K key) {

        // Handling if we want to delete the root node
        if (rootNode != null && key.compareTo(rootNode.getData().getKey()) == 0) {
            if (rootNode.getLeftNode() == null && rootNode.getLeftNode() == null) {
                rootNode = null;
                return true;
            }
            if (rootNode.getLeftNode() == null) {
                rootNode = rootNode.getRightNode();
                return true;
            }
            if (rootNode.getRightNode() == null) {
                rootNode = rootNode.getLeftNode();
                return true;
            }
            Node<K, V> leftTreeRightestNode = rootNode.getLeftNode();
            Node<K, V> rightTreeStartNode = rootNode.getRightNode();
            while (leftTreeRightestNode.getRightNode() != null) {
                leftTreeRightestNode = leftTreeRightestNode.getRightNode();
            }
            leftTreeRightestNode.setRightNode(rightTreeStartNode);
            rootNode = rootNode.getLeftNode();
            return true;
        }

        // Handling if we want to delete any other node
        Node<K, V> treeIterator = rootNode;
        while (treeIterator != null) {
            if (treeIterator.getLeftNode() != null
                    && treeIterator.getLeftNode().getData().getKey().compareTo(key) == 0) {
                treeIterator.setLeftNode(deleteNode(treeIterator.getLeftNode()));
                return true;
            } else if (treeIterator.getRightNode() != null &&
                    treeIterator.getRightNode().getData().getKey().compareTo(key) == 0) {
                treeIterator.setRightNode(deleteNode(treeIterator.getRightNode()));
                return true;
            } else {
                if (treeIterator.getRightNode() != null && treeIterator.getData().getKey().compareTo(key) < 0) {
                    treeIterator = treeIterator.getRightNode();
                } else if (treeIterator.getLeftNode() != null && treeIterator.getData().getKey().compareTo(key) > 0) {
                    treeIterator = treeIterator.getLeftNode();
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Method to get the value of the corrosponding input key
     * 
     * @param key
     * @return value of the corrosponding input key, otherwise null
     */
    public V getValue(K key) {
        Node<K, V> tempNode = rootNode;
        while (tempNode != null && (tempNode.getLeftNode() != null || tempNode.getRightNode() != null)) {
            if (tempNode.getData().getKey().compareTo(key) > 0) {
                tempNode = tempNode.getLeftNode();
            } else if (tempNode.getData().getKey().compareTo(key) < 0) {
                tempNode = tempNode.getRightNode();
            } else if (tempNode.getData().getKey().compareTo(key) == 0) {
                return tempNode.getData().getValue();
            }
        }
        if (tempNode.getData().getKey().compareTo(key) == 0) {
            return tempNode.getData().getValue();
        }
        return null;
    }

    /**
     * Method to iterator through the tree recurrsivly and add Pair objects to the
     * list
     * 
     * @param sortedKeyValueList shoudld be of Pair type
     * @param treeIterator       should be of Node type
     */
    public void getSortedListHelper(List<Pair<K, V>> sortedKeyValueList, Node<K, V> treeIterator) {
        if (treeIterator == null) {
            return;
        }
        getSortedListHelper(sortedKeyValueList, treeIterator.getLeftNode());
        sortedKeyValueList.add(treeIterator.getData());
        getSortedListHelper(sortedKeyValueList, treeIterator.getRightNode());
    }

    /**
     * Method to get the sorted List of Pair object
     * 
     * @return sorted list of pair object
     */
    public List<Pair<K, V>> getSortedList() {
        List<Pair<K, V>> sortedKeyValueList = new ArrayList<Pair<K, V>>();
        getSortedListHelper(sortedKeyValueList, rootNode);
        return sortedKeyValueList;
    }

    /**
     * Method that helps in iterating through the tree and add the value in the
     * range
     * 
     * @param treeIterator       should be of Node type
     * @param sortedKeyValueList should be of Pair type
     * @param startKey           holds the lower range
     * @param endKey             holds the upper range
     */
    public void getSortedListBetweenInRangeHelper(Node<K, V> treeIterator, List<Pair<K, V>> sortedKeyValueList,
            K startKey, K endKey) {
        if (treeIterator == null) {
            return;
        }

        if (treeIterator.getData().getKey().compareTo(startKey) >= 0
                && treeIterator.getData().getKey().compareTo(endKey) <= 0) {
            getSortedListBetweenInRangeHelper(treeIterator.getLeftNode(), sortedKeyValueList, startKey, endKey);
            sortedKeyValueList.add(treeIterator.getData());
            getSortedListBetweenInRangeHelper(treeIterator.getRightNode(), sortedKeyValueList, startKey, endKey);
        } else if (treeIterator.getData().getKey().compareTo(startKey) <= 0) {
            getSortedListBetweenInRangeHelper(treeIterator.getRightNode(), sortedKeyValueList, startKey, endKey);
        } else if (treeIterator.getData().getKey().compareTo(endKey) >= 0) {
            getSortedListBetweenInRangeHelper(treeIterator.getLeftNode(), sortedKeyValueList, startKey, endKey);
        }
    }

    /**
     * Method to the get the sorted List of pair in a range
     * 
     * @param startKey holds the lower range
     * @param endKey   holds the upper range
     * @return sorted List of pair object ranging from start and end key
     */
    public List<Pair<K, V>> getSortedListBetweenInRange(K startKey, K endKey) {
        List<Pair<K, V>> sortedKeyValueList = new ArrayList<Pair<K, V>>();
        getSortedListBetweenInRangeHelper(rootNode, sortedKeyValueList, startKey, endKey);
        return sortedKeyValueList;
    }

    /**
     * Method to display the tree from the input node
     * 
     * @param rootNode should be of Node type
     */
    public void displayTree(Node<K, V> rootNode) {
        if (rootNode == null) {
            return;
        }
        displayTree(rootNode.getLeftNode());
        System.out.println(rootNode.getData().getKey() + " -> " + rootNode.getData().getValue());
        displayTree(rootNode.getRightNode());
    }
}

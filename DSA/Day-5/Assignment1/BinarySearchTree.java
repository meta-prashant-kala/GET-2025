import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<K extends Comparable<K>, V> implements Dictionary<K, V> {
    Node<K, V> rootNode;

    public BinarySearchTree(String json) {
        createInitialTree(json);
    }

    public BinarySearchTree(){
        rootNode=null;
    }

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

    public Node<K, V> getRootNode() {
        return rootNode;
    }

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

    public Node<K, V> deleteNode(Node<K, V> treeNodeIterator) {
        System.out.println("D : i am done with you");
        if (treeNodeIterator.getLeftNode() == null && treeNodeIterator.getRightNode() == null) {
            return null;
        }
        if (treeNodeIterator.getLeftNode() == null) {
            System.out.println("D : Pass right");
            return treeNodeIterator.getRightNode();
        }
        if (treeNodeIterator.getRightNode() == null) {
            System.out.println("D : Pass left");
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

    public boolean deleteValue(K key) {
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

    public void getSortedListHelper(List<Pair<K, V>> sortedKeyValueList, Node<K, V> treeIterator) {
        if (treeIterator == null) {
            return;
        }
        getSortedListHelper(sortedKeyValueList, treeIterator.getLeftNode());
        sortedKeyValueList.add(treeIterator.getData());
        getSortedListHelper(sortedKeyValueList, treeIterator.getRightNode());
    }

    public List<Pair<K, V>> getSortedList() {
        List<Pair<K, V>> sortedKeyValueList = new ArrayList<Pair<K, V>>();
        getSortedListHelper(sortedKeyValueList, rootNode);
        return sortedKeyValueList;
    }

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

    public List<Pair<K, V>> getSortedListBetweenInRange(K startKey, K endKey) {
        List<Pair<K, V>> sortedKeyValueList = new ArrayList<Pair<K, V>>();
        getSortedListBetweenInRangeHelper(rootNode, sortedKeyValueList, startKey, endKey);
        return sortedKeyValueList;
    }

    public void displayTree(Node<K, V> rootNode) {
        if (rootNode == null) {
            return;
        }
        displayTree(rootNode.getLeftNode());
        System.out.println(rootNode.getData().getKey() + " -> " +rootNode.getData().getValue());
        displayTree(rootNode.getRightNode());
    }
}

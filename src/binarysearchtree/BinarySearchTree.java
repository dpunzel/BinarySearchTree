package binarysearchtree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public Node<T> getRoot() {
        return this.root;
    }

    @Override
    public Node<T> getKSmallest(Node<T> node, int k) {
        // number of nodes in the left subtree
        // + 1 because we count the root
        int n = treeSize(node.getLeftChild()) + 1;
        // this is when we find the kth smallest item
        if (n == k) {
            return node;
        }

        // if the number of nodes in the left subtree > k-th smallest item
        // the k-th smallest item is in the left sub tree
        if (n > k) return getKSmallest(node.getLeftChild(), k);

        // if number of nodes in the left subtree is smaller then the k-th
        //smallest item then we can consider the right subtree
        if (n < k) return getKSmallest(node.getRightChild(), k - n);

        return null;
    }

    // helper method to calculate size of subtree with root node 'node'
    private int treeSize(Node<T> node) {
        // base case
        if (node == null) return 0;

        // recursively sum up the size of left + size of right subtree
        // size of tree = size of left + right + 1 for root
        return (treeSize(node.getLeftChild()) + treeSize(node.getRightChild()) + 1);
    }

    @Override
    public void insert(T data) {
        if (root == null) {
            root = new Node<T>(data);
        } else {
            insertNode(data, root);
        }
    }

    @Override
    public T getMaxValue() {
        if (root == null) return null;

        return getMax(root);
    }

    @Override
    public T getMinValue() {
        if (root == null) return null;

        return getMin(root);
    }

    @Override
    public void traversal() {
        if (root != null) {
            inOrderTraversal(root);
        }
    }

    private void inOrderTraversal(Node<T> node) {
        // if left child not null, recursively search leftChild
        if (node.getLeftChild() != null)
            inOrderTraversal(node.getLeftChild());
        System.out.print(node + "  -->  ");

        if (node.getRightChild() != null)
            inOrderTraversal(node.getRightChild());
    }

    private Node<T> delete(Node<T> node, T data) {

        // if node is null return node

        if (node == null) return node;

        // if the given data to be removed is smaller
        // than the node we want to remove, consider the left sub tree
        if (data.compareTo(node.getData()) < 0 ) {
            node.setLeftChild(delete(node.getLeftChild(), data));
        } else if (data.compareTo(node.getData()) > 0){
            node.setRightChild(delete(node.getRightChild(), data));
        } else {
            // we have found the node we want to remove
            // this is where we check if given node is a leaf node
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                System.out.println("Removing a leaf node... ");
                return null;
            }

            // Here we know it has either left child or right child
            if (node.getLeftChild() == null) {
                System.out.println("Removing the right child...");
                Node<T> tempNode = node.getRightChild();
                node = null;
                return tempNode;
            } else if (node.getRightChild() == null) {
                System.out.println("Removing the left child...");
                Node<T> tempNode = node.getLeftChild();
                node = null;
                return tempNode;
            }

            // This is the node with two children
            System.out.println("Removing item with two children.... ");
            Node<T> tempNode = getPredecessor(node.getLeftChild());

            node.setData(tempNode.getData());
            node.setLeftChild(delete(node.getLeftChild(), tempNode.getData()));

        }
        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRightChild() != null)
            return  getPredecessor(node.getRightChild());

        return node;
    }

    private void insertNode(T newData, Node<T> node) {
        // check if greater or smaller
        if (newData.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() != null) {
                insertNode(newData, node.getLeftChild());
            } else {
                // means left child equal to zero insert here
                Node<T> newNode = new Node<T>(newData);
                node.setLeftChild(newNode);
            }
        } else {
            // check right child not null
            if (node.getRightChild() != null) {
                // not null can call recursively to get right child
                insertNode(newData, node.getRightChild());
            } else {
                // means right child equal to zero insert here
                Node<T> newNode = new Node<T>(newData);
                node.setRightChild(newNode);
            }
        }
    }

    @Override
    public void delete(T data) {
        if (root != null)
            root = delete(root, data);
    }


    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            // if not null, recursively call getMax to find largest value
            return getMax(node.getRightChild());
        }

        return node.getData();
    }


    private T getMin(Node<T> node) {

        if (node.getLeftChild() != null) {
            // if not null, recursively call getMin to find lowest value
            return getMin(node.getLeftChild());
        }

        return node.getData();
    }
}

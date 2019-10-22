package binarysearchtree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

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
        // if not left child not null, recursively search leftChild
        if (node.getLeftChild() != null)
            inOrderTraversal(node.getLeftChild());
        System.out.print(node + "  -->  ");

        if (node.getRightChild() != null)
            inOrderTraversal(node.getRightChild());
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

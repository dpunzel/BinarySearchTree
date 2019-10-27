package binarysearchtree;

public interface Tree<T> {
    int getAgesSum();
    // modified for finding kth smallest item
    Node<T> getKSmallest(Node<T> node, int k);
    // modified for TreeCompareHelper, added Node<T> getRoot()
    Node<T> getRoot();
    void traversal();
    void insert(T data);
    void delete(T data);
    T getMaxValue();
    T getMinValue();
}

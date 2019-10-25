package binarysearchtree;

public interface Tree<T> {
    // modified for TreeCompareHelper, added Node<T> getRoot()
    public Node<T> getRoot();
    public void traversal();
    public void insert(T data);
    public void delete(T data);
    public T getMaxValue();
    public T getMinValue();
}

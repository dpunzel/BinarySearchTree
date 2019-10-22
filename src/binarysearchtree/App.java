package binarysearchtree;

public class App {
    public static void main(String[] args) {
        Tree<Integer> bst = new BinarySearchTree<>();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);

        bst.traversal();
        bst.delete(10);
        bst.traversal();

    }
}

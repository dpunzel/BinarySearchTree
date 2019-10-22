package binarysearchtree;

public class App {
    public static void main(String[] args) {
        Tree<String> bst = new BinarySearchTree<>();

        bst.insert("Zany");
        bst.insert("Tommy");
        bst.insert("Madden");
        bst.insert("Cory");
        bst.insert("Hector");
        bst.insert("Adam");

//        System.out.println(bst.getMaxValue());
//        System.out.println(bst.getMinValue());
        bst.traversal();

    }
}

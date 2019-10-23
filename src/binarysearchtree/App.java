package binarysearchtree;

public class App {
    public static void main(String[] args) {

        Tree<Person> bst = new BinarySearchTree<>();

        bst.insert(new Person("Adam", 28));
        bst.insert(new Person("Peter", 12));
        bst.insert(new Person("Kelly", 42));
        bst.insert(new Person("Toby", 62));
        bst.insert(new Person("Bob", 32));

        bst.traversal();
//        Tree<Integer> bst = new BinarySearchTree<>();
//
//        bst.insert(10);
//        bst.insert(5);
//        bst.insert(15);
//        bst.insert(3);
//        bst.insert(7);
//
//        bst.delete(15);
//        bst.traversal();

    }
}

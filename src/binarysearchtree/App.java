package binarysearchtree;

public class App {
    public static void main(String[] args) {
        Tree<Person> bst = new BinarySearchTree<>();

        bst.insert(new Person("Adam", 47));
        bst.insert(new Person("Kevin", 21));
        bst.insert(new Person("Joe", 55));
        bst.insert(new Person("Arnold", 20));
        bst.insert(new Person("Noel", 34));
        bst.insert(new Person("Marko", 68));
        bst.insert(new Person("Susan", 23));
        bst.insert(new Person("Rose", 38));

        System.out.println(bst.getAgesSum());

//        Tree<Integer> bst = new BinarySearchTree<>();
//
//        bst.insert(2);
//        bst.insert(55);
//        bst.insert(67);
//        bst.insert(12);
//        bst.insert(11);
//
//        System.out.println(bst.getKSmallest(bst.getRoot(), 4));

//        Tree<Integer> bst2 = new BinarySearchTree<>();
//
//        bst2.insert(2);
//        bst2.insert(21);
//        bst2.insert(222);
//        bst2.insert(2222);
//        bst2.insert(22222);
//
//        TreeCompareHelper<Integer> helper = new TreeCompareHelper<>();
//
//        System.out.println(helper.compareTrees(bst.getRoot(), bst2.getRoot()));

//        Tree<Person> bst = new BinarySearchTree<>();
//
//        bst.insert(new Person("Adam", 28));
//        bst.insert(new Person("Peter", 12));
//        bst.insert(new Person("Kelly", 42));
//        bst.insert(new Person("Toby", 62));
//        bst.insert(new Person("Bob", 32));
//
//        bst.traversal();
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

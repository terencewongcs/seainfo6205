public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree1 = getTree1();
        BinaryTree<Integer> tree2 = getTree2();

        System.out.println(tree1.isSameTree(tree1.root, tree2.root));
    }

    private static BinaryTree<Integer> getTree1(){
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.root = new Node<>(1);
        tree.root.left = new Node<>(2);
        tree.root.right = new Node<>(3);
        tree.root.left.left = new Node<>(4);

        return tree;
    }

    private static BinaryTree<Integer> getTree2(){
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.root = new Node<>(1);
        tree.root.left = new Node<>(2);
        tree.root.right = new Node<>(3);
        tree.root.left.left = new Node<>(4);

        return tree;
    }
}
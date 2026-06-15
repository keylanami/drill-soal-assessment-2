package SC01;
public class BST {

    private Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node current, int data) {

        if(current == null) {
            return new Node(data);
        }

        if(data < current.data) {
            current.left = insert(current.left, data);
        }
        else if(data > current.data) {
            current.right = insert(current.right, data);
        }

        return current;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node current) {

        if(current != null) {

            inorder(current.left);

            System.out.print(current.data + " ");

            inorder(current.right);
        }
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node current) {

        if(current == null) {
            return 0;
        }

        return 1
                + countNodes(current.left)
                + countNodes(current.right);
    }
}
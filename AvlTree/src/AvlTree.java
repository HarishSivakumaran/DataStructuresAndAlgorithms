public class AvlTree {

    private static Node root;

    public static class Node {
        int data;
        Node left;
        Node right;
        int height = 1;

        public Node(int data) {

            this.data = data;
        }
    }

    public static int height(Node node) {

        return node.height;
    }

    public static int getBalance(Node node) {

        return (node.left.height - node.right.height);
    }

    public static Node rotateRight(Node node) {

        Node y = node.left;
        Node z = y.right;

        y.right = node;
        node.left = z;
        node.height = 1 + Math.max(height(node.right), height(node.left));
        y.height = 1 + Math.max(height(y.right), height(y.left));
        return y;
    }

    public static Node rotateLeft(Node node) {

        Node x = node.right;
        Node y = x.left;

        x.left = node;
        node.right = y;

        node.height = 1 + Math.max(height(node.right), height(node.left));
        x.height = 1 + Math.max(height(x.right), height(x.left));

        return x;
    }

    public static Node insertNode(int data, Node node) {

        if (node == null) {
            return (new Node(data));
        }

        if (data < node.data) {
            node.left = insertNode(data, node.left);
        } else if (data > node.data) {
            node.right = insertNode(data, node.right);
        } else {
            return node;
        }
        node.height = 1 + Math.max(node.left.height, node.right.height);
        int balance = getBalance(node);
        // LL
        if ((balance > 1) && (node.left.data > data)) {
     return rotateRight(node);
        }
// RR
        if ((balance < -1) && (node.right.data < data)) {
            return rotateLeft(node);
        }

        //LR
        if ((balance > 1) && (node.left.data < data)) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        //RL
        if ((balance < -1) && (node.right.data > data)) {
            node.left = rotateRight(node.left);
            return rotateLeft(node);
        }

        return node;
    }

    public static void main(String[] args) {

    }
}

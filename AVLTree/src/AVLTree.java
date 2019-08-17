import java.util.ArrayList;

public class AVLTree {

    private static Node root;

    private static class Node {
        int data;
        Node parent;
        Node leftChild;
        Node rightChild;

        public Node(int data) {

            this.data = data;
        }
    }

    public static Node find(int data, Node node) {

        if (node.data == data) {
            return node;
        }
        if (node.data > data) {
            if (node.leftChild != null)
                return find(data, node.leftChild);
            return node;

        } else if (data > node.data) {
            if (node.rightChild != null)
                return find(data, node.rightChild);
            return node;
        }

        return node;
    }

    public static Node findParent(int data, Node node) {

        if ((node.rightChild.data == data) || (node.leftChild.data == data)) {
            return node;
        }
        if (node.data > data) {
            if (node.leftChild != null)
                return find(data, node.leftChild);
            return node;

        } else if (data > node.data) {
            if (node.rightChild != null)
                return find(data, node.rightChild);
            return node;
        }

        return node;
    }

    public static Node next(int data, Node node) {

        node = find(data, node);

        if (node.rightChild != null) {
            return leftDescendant(node.rightChild);
        } else {
            return rightAncestor(node.leftChild);
        }
    }

    public static Node leftDescendant(Node node) {

        if (node.leftChild == null)
            return node;
        return leftDescendant(node.leftChild);
    }

    public static Node rightAncestor(Node node) {

        if (node.parent.data > node.data) {
            return node.parent;
        }
        if (node.parent != null)
            return rightAncestor(node.parent);

        return node;

    }

    public static ArrayList<Node> rangeOfSearch(int data, Node node, int endData) {

        node = find(data, node);
        ArrayList<Node> arrayList = new ArrayList<>();
        while (node.data <= endData) {
            if (node.data >= data)
                arrayList.add(node);
            node = next(data, node);
        }
        return arrayList;
    }

    private static void insertion(Node node) {

        if (root == null) {
            root = node;
            return;
        }
        Node nodeToInsert = find(node.data, node);
        if (node.data < nodeToInsert.data) {
            nodeToInsert.leftChild = node;
            node.parent = nodeToInsert;
        } else {
            nodeToInsert.rightChild = node;
            node.parent = nodeToInsert;

        }

    }


    public static Node deletion(int data, Node root) {

        if (root == null)
            return root;

        if (root.data < data) {
            root.rightChild = deletion(data, root.rightChild);
        } else if (data < root.data) {
            root.leftChild = deletion(data, root.leftChild);
        } else {
            if (root.rightChild == null) {
                return root.leftChild;
            } else if (root.leftChild == null) {
                return root.rightChild;
            }

            root.data= next(root.data,root).data;

         root.rightChild=   deletion(root.data,root.rightChild);

        }

        return  root;
    }

    public static void main(String[] args) {

    }

}

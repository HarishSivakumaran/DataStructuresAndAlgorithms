// java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BinaryTreeQ1 {

    private static Node root;

    public static class Node {
        int data;
        Node parent;
        Node left;
        Node right;

        public Node(int data) {

            this.data = data;
        }
    }

    public static void createTree(Node node,int[][] allNodes,Node[] allNodeArr) {

       for(int i=0; i<allNodeArr.length;i++){

       }

    }

    public static void main(String[] args) {

        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int noOfNodes = scanner.nextInt();
        Node[] allNodeArr = new Node[noOfNodes];
        int[][] nodesAndChildren = new int[noOfNodes][3];

        for (int i = 0; i < noOfNodes; i++) {
            for (int j = 0; j < 3; j++) {
                nodesAndChildren[i][j] = scanner.nextInt();
            }
        }

    }
}

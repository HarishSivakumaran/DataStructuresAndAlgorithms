import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class TreeHeight {

    private static class TreeNode {
        private int data;
        private ArrayList<TreeNode> childTreeNodes = new ArrayList<>();

        TreeNode(int data) {

            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<TreeNode> arrTreeNode = new ArrayList<>();
        int rootIndex = 0;
        int noOfNodes = Integer.parseInt(bufferedReader.readLine());
        int[] parentNode = Arrays.stream(bufferedReader.readLine().replaceAll("\\s+", " ").split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < noOfNodes; i++) {
            arrTreeNode.add(new TreeHeight.TreeNode(i));
        }

        for (int i = 0; i < parentNode.length; i++) {
            if (parentNode[i] == -1) {
                rootIndex = i;
            } else {
                arrTreeNode.get(parentNode[i]).childTreeNodes.add(arrTreeNode.get(i));
            }

        }

        System.out.println(maxHeight(arrTreeNode.get(rootIndex)));

    }
    // Arrays.stream(new int[]{1, 2, 3, 4, 5}).mapToObj((int a)->{ return 5;}).toArray();
    //        TreeHeight treeHeight = new TreeHeight();
    //        treeHeight.printArray(new int[]{1, 2, 3, 4});
    //        Check check = new Check();
    //        check.nothing();

    public static long maxHeight(TreeHeight.TreeNode treeNode) {

        if (treeNode.childTreeNodes.isEmpty()) {
            return 1;
        }
        long max = -1;
        for (TreeHeight.TreeNode node : treeNode.childTreeNodes) {

            long height = 1 + maxHeight(node);
            if (height > max) {
                max = height;
               // System.out.println(max);
            }
        }
        return max;

    }

    protected void printArray(int[] arr) {

        for (int i : arr) {
            System.out.println(i);
        }
    }
}

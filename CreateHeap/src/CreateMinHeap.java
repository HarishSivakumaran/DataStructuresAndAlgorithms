import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CreateMinHeap {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        buildHeap(arr);

    }


    public static void buildHeap(int[] arr) {
        ArrayList<String> allSwaps = new ArrayList<>();

        for (int i = arr.length / 2; i >= 0; i--) {
            shiftDown(arr, i,allSwaps);
        }

        System.out.println(allSwaps.size());
for(String s : allSwaps){
    System.out.println(s);

}


    }

    public static void shiftDown(int[] arr, int i, ArrayList<String> allSwaps ) {

        int minIndex = i;
        if (leftChild(i) < arr.length)
            if (arr[leftChild(i)] < arr[minIndex]) {
                minIndex = leftChild(i);
            }
        if (rightChild(i) < arr.length)
            if (arr[rightChild(i)] < arr[minIndex]) {
                minIndex = rightChild(i);
            }

        if (minIndex == i)
            return;
        swap(i, minIndex, arr);
        allSwaps.add(i + " " + minIndex);
        shiftDown(arr, minIndex,allSwaps);

    }

    public static void swap(int a, int b, int[] arr) {

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int leftChild(int i) {

        return (2 * i + 1);
    }

    public static int rightChild(int i) {

        return (2 * i + 2);
    }

    public static int parentOf(int i) {

        return (i - 1) / 2;
    }

}

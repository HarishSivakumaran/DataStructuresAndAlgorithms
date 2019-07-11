import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays
                .stream(bufferedReader
                        .readLine()
                        .replaceAll("\\s+", " ")
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("unsorted array is");
        printArray(array);
        System.out.println("sorted array is");

        int[] result = mergeSort(array);
        printArray(result);

    }

    public static int[] mergeSort(int[] array) {

        if (array.length <= 1) {
            return array;
        }
        int midpoint = array.length / 2;
        int[] left = new int[midpoint];
        int[] right = new int[array.length - midpoint];
        int[] result = new int[array.length];

        for (int i = 0; i < midpoint; i++) {

            left[i] = array[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = array[midpoint + i];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        result = merge(left, right);
        return result;

    }

    public static int[] merge(int[] left, int[] right) {

        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;
        int[] result = new int[left.length + right.length];

        while ((leftPointer < left.length) || (rightPointer < right.length)) {

            if ((leftPointer < left.length) && (rightPointer < right.length)) {

                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];

                } else {
                    result[resultPointer++] = right[rightPointer++];

                }

            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];

            } else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];

            }

        }
        return result;

    }


    public static void printArray(int[] a) {

        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}

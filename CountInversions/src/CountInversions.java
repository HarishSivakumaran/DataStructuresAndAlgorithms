import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountInversions {

    public static void printArray(int[] array) {

        for (int i : array) {
            System.out.println(i);
        }
    }

    public static int[] mergeSort(int[] array, int[] inversionCount) {

        if (array.length <= 1) {
            return array;
        }
        int midpoint = array.length / 2;

        int[] left = new int[midpoint];
        int[] right = new int[array.length - midpoint];

        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }
        for (int i = 0; i < right.length; i++) {

            right[i] = array[midpoint + i];

        }

        left = mergeSort(left, inversionCount);
        right = mergeSort(right, inversionCount);

        int[] result = merge(left, right, inversionCount);

        return result;
    }

    public static int[] merge(int[] left, int[] right, int[] inversionCount) {

        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;
        int[] result = new int[left.length + right.length];

        while ((leftPointer < left.length) || (rightPointer < right.length)) {

            if ((leftPointer < left.length) && (rightPointer < right.length)) {

                if (left[leftPointer] <= right[rightPointer]) {

                    result[resultPointer++] = left[leftPointer++];

                } else if (right[rightPointer] < left[leftPointer]) {

                    result[resultPointer++] = right[rightPointer++];

                    inversionCount[0] += left.length - leftPointer;

                }
            } else if (leftPointer < left.length) {

                result[resultPointer++] = left[leftPointer++];

            } else if (rightPointer < right.length) {

                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays
                .stream(bufferedReader.readLine()
                        .replaceAll("\\s+", " ")
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] inversionCount = {0};

        //        Arrays.sort(a);
        //        printArray(a);

        int[] result = mergeSort(array, inversionCount);

        printArray(result);

        System.out.println(inversionCount[0]);

    }
}

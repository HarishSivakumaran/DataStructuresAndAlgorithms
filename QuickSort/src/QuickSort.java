import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println("unsortedArray is");
        printArray(array);

        int pivot = array.length - 1;

        quickSort(array, 0, pivot);
        System.out.println();
        printArray(array);

    }

    public static void quickSort(int[] array, int low, int high) {

        if (low < high) {
            int newPivot = partition(array, low, high);

            quickSort(array, low, newPivot - 1);
            quickSort(array, newPivot + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {

        int pivot = array[high];

        int i = low - 1;
        int j = low;

        for (j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }

        int temp = array[high];
        array[high] = array[i + 1];
        array[i + 1] = temp;

        return i + 1;

    }

    public static void printArray(int[] array) {

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

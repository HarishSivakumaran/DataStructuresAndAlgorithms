import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) throws IOException {

        System.out.println("please enter the array");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Scanner scanner = new Scanner(System.in);
        int noToSearch = scanner.nextInt();

        System.out.println(binarySearch(array, noToSearch));

    }

    public static int binarySearch(int[] array, int n) {

        int left = 0;
        int right = array.length - 1;
        int midpoint = (right - left) / 2;

        while (left <= right) {
            midpoint = ((right - left) / 2) + left;
            if (array[midpoint] == n) {
                return midpoint;
            } else if (array[midpoint] < n) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }

        return -1;

    }

}
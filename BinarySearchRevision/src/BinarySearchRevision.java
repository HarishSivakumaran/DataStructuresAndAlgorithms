import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearchRevision {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] arrNos = Arrays.stream(bufferedReader.readLine().replaceAll("\\s+", " ").split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getIndexOfReqNo(arrNos, 6));

    }

    public static int getIndexOfReqNo(int[] arr, int reqNo) {

        int midPoint = arr.length / 2;
        if (arr[midPoint] == reqNo) {
            return midPoint;
        }

        if (arr[midPoint] > reqNo) {
            int i;
            int[] arraLeft = new int[midPoint];
            for (i = 0; i < midPoint; i++) {
                arraLeft[i] = arr[i];

            }
            return getIndexOfReqNo(arraLeft, reqNo);
        }
        if (arr[midPoint] == reqNo) {
            return midPoint;
        }

        if (arr[midPoint] < reqNo) {
            int i;
            int[] arraRight = new int[arr.length - midPoint - 1];
            for (i = 0; i < arr.length - midPoint - 1; i++) {
                arraRight[i] = arr[midPoint + i + 1];

            }
            return getIndexOfReqNo(arraRight, reqNo);
        }
        return -1;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BinaryMaxHeapCustom {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


    }

    public static class BinaryHeap {
        int[] arr;

        public BinaryHeap(int[] arr) {

            this.arr = arr;
        }

        public void shiftUp(int[] arr, int i) {

            while (arr[i] > arr[parentOfNode(i)]) {
                if (i == 0) {
                    break;
                }
                int temp = arr[i];
                arr[i] = arr[parentOfNode(i)];
                arr[parentOfNode(i)] = temp;
                i = parentOfNode(i);
            }
        }

        public void shiftDown(int[] arr, int i) {

            int maxIndex = i;
                if ((leftOfNode(i) < arr.length) && (arr[leftOfNode((i))] > arr[maxIndex])) {
                    maxIndex = leftOfNode((i));
                }

                if ((rightOfNode(i) < arr.length) && (arr[rightOfNode((i))] > arr[maxIndex])) {
                    maxIndex = rightOfNode((i));
                }
                if (i != maxIndex) {
                    swap(arr,i,maxIndex);
                     shiftDown(arr,maxIndex);
                     return;
                }else{
                    return;
                }


        }
        public void swap(int[] arr,int i,int maxIndex ){
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }

        public int leftOfNode(int i) {

            return (2 * i + 2);
        }

        public int rightOfNode(int i) {

            return (2 * i + 3);
        }

        public int parentOfNode(int i) {

            return (i - 1) / 2;
        }

        public int getMax(int[] arr) {
        return arr[0];
        }

        public int extractMax(int[] arr){
            swap(arr,0,arr.length-1);
          //  Collections.reverseOrder();

        }

        public void insert(int[] arr, int noToBeInserted) {

        }
    }
}

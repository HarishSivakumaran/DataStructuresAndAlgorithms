
import java.io.*;
import java.util.*;
public class InsertionSort {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        insertionSort(arr);

    }

    public static void printArray(int[] arr){
        for(int i : arr){
            System.out.println(i);
        }
    }


    public static void insertionSort(int[] arr){

        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j=i-1;

            while ((j>=0)&&(arr[j]>key)){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=key;

        }

        printArray(arr);

    }
}

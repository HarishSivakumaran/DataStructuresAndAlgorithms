import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BinaryMaxHeap {

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      //  new Hashtable<String,Integer>().forEach((String key, Integer value)->{});

        for(Integer i : arr){
            priorityQueue.add(i);

        }

       Iterator<Integer> minHeap = priorityQueue.iterator();

       while(minHeap.hasNext()){
           System.out.println(minHeap.next());
       }


    }
}

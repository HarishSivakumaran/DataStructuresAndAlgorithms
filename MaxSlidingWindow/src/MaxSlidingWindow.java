import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class MaxSlidingWindow {

    public static class CustomQueue<T> {

        Stack<T> stackBuffer = new Stack<>();
        Stack<T> queue = new Stack<>();

        public void enQueue(T a) {

            if (queue.isEmpty()) {
                queue.push(a);
                return;
            }

            while (!queue.isEmpty()) {
                stackBuffer.push(queue.pop());
            }

            stackBuffer.push(a);

            while (!stackBuffer.isEmpty()) {
                queue.push(stackBuffer.pop());
            }

        }

        public void deQueue() {

            queue.pop();
        }

        public boolean isEmpty() {

            return queue.isEmpty();
        }

    }

    public static void main(String[] args) throws IOException {

        CustomQueue<Integer> customQueue = new CustomQueue<Integer>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int[] arr = Arrays.stream(bufferedReader.readLine().replaceAll("\\s+", " ").split(" ")).mapToInt(Integer::parseInt).toArray();

        int noOfSubArr = Integer.parseInt(bufferedReader.readLine());

        int startIndex = 0;
        int stopIndex = noOfSubArr - 1;
        int max = -1;

        while (stopIndex <= arr.length - 1) {
            if (max == -1)
                for (int i = 0; i < noOfSubArr; i++) {
                    max = Math.max(max, arr[startIndex + i]);
                }
            if (max < arr[stopIndex]) {
                max = arr[stopIndex];
            }
            System.out.print(max + " ");
            if (max == arr[startIndex]) {
                max = -1;
            }
            startIndex++;
            stopIndex++;
        }

    }

    public static void printMaxNos(CustomQueue<Integer> intQueue, int noOfElements) {

        if (intQueue.isEmpty()) {
            return;
        }

        for (int i = 0; i < noOfElements; i++) {

        }

    }
}

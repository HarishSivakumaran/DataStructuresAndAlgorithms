import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JobQueue {

    public static class ThreadAndNextFreeSlot {
        int threadNo;
        long nextFreeSlot;

        public ThreadAndNextFreeSlot(int threadNo, long nextFreeSlot) {

            this.nextFreeSlot = nextFreeSlot;
            this.threadNo = threadNo;
        }

    }

    public static class ThreadComparator implements Comparator<ThreadAndNextFreeSlot> {


        @Override
        public int compare(ThreadAndNextFreeSlot o1, ThreadAndNextFreeSlot o2) {

            if ((o1.nextFreeSlot - o2.nextFreeSlot) > 0) {
                return (int) (o1.nextFreeSlot - o2.nextFreeSlot);
            } else if ((o1.nextFreeSlot - o2.nextFreeSlot) == 0) {
                return o1.threadNo - o2.threadNo;
            }

            return (int) (o1.nextFreeSlot - o2.nextFreeSlot);  //just a fallback case
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<ThreadAndNextFreeSlot> priorityQueue = new PriorityQueue<>(new ThreadComparator());
        int[] noOfThreadsAndJobs = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] jobsDuration = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        ThreadAndNextFreeSlot[] threadAndNextFreeSlots = new ThreadAndNextFreeSlot[noOfThreadsAndJobs[0]];

        for (int i = 0; i < noOfThreadsAndJobs[0]; i++) {
            threadAndNextFreeSlots[i] = new ThreadAndNextFreeSlot(i, 0);
            priorityQueue.add(new ThreadAndNextFreeSlot(i, 0));
        }
        assignJobs(threadAndNextFreeSlots, jobsDuration, priorityQueue);
    }

    public static void assignJobs(ThreadAndNextFreeSlot[] threadAndNextFreeSlots, long[] jobDuration, PriorityQueue<ThreadAndNextFreeSlot> priorityQueue) {

        String[] jobStartTime = new String[jobDuration.length];

        for (int i = 0; i < jobDuration.length; i++) {

            ThreadAndNextFreeSlot threadAndNextFreeSlots1 = priorityQueue.poll();
            jobStartTime[i] = threadAndNextFreeSlots1.threadNo + " " + threadAndNextFreeSlots1.nextFreeSlot;
            threadAndNextFreeSlots1.nextFreeSlot += jobDuration[i];
            priorityQueue.add(threadAndNextFreeSlots1);

        }

        for (String a : jobStartTime) {
            System.out.println(a);
        }

    }

    public static void createBinaryMinHeap(ThreadAndNextFreeSlot[] threadAndNextFreeSlots, PriorityQueue<ThreadAndNextFreeSlot> priorityQueue) {

        priorityQueue.poll();
        for (int i = threadAndNextFreeSlots.length / 2; i >= 0; i--) {
            siftDown(threadAndNextFreeSlots, i);
        }
    }

    public static void siftDown(ThreadAndNextFreeSlot[] threadAndNextFreeSlots, int i) {

        int minIndex = i;
        if (leftChild(i) < threadAndNextFreeSlots.length)
            if (threadAndNextFreeSlots[leftChild(i)].nextFreeSlot < threadAndNextFreeSlots[minIndex].nextFreeSlot) {
                minIndex = leftChild(i);
                if ((leftChild(i) < threadAndNextFreeSlots.length) && (rightChild(i) < threadAndNextFreeSlots.length))
                    if (threadAndNextFreeSlots[rightChild(i)].nextFreeSlot == threadAndNextFreeSlots[leftChild(i)].nextFreeSlot) {
                        minIndex = threadAndNextFreeSlots[rightChild(i)].threadNo > threadAndNextFreeSlots[leftChild(i)].threadNo ? leftChild(i) : rightChild(i);
                    }
            }
        if (rightChild(i) < threadAndNextFreeSlots.length)
            if (threadAndNextFreeSlots[rightChild(i)].nextFreeSlot < threadAndNextFreeSlots[minIndex].nextFreeSlot) {
                minIndex = rightChild(i);
                if ((leftChild(i) < threadAndNextFreeSlots.length) && (rightChild(i) < threadAndNextFreeSlots.length))
                    if (threadAndNextFreeSlots[rightChild(i)].nextFreeSlot == threadAndNextFreeSlots[leftChild(i)].nextFreeSlot) {
                        minIndex = threadAndNextFreeSlots[rightChild(i)].threadNo > threadAndNextFreeSlots[leftChild(i)].threadNo ? leftChild(i) : rightChild(i);
                    }
            }

        if (minIndex == i) {

            return;
        }

        ThreadAndNextFreeSlot temp = threadAndNextFreeSlots[minIndex];
        threadAndNextFreeSlots[minIndex] = threadAndNextFreeSlots[i];
        threadAndNextFreeSlots[i] = temp;

        siftDown(threadAndNextFreeSlots, minIndex);

    }

    public static int leftChild(int i) {

        return (2 * i + 1);
    }

    public static int rightChild(int i) {

        return (2 * i + 2);
    }

}

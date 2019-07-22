import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class CoinChangeProblem {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        minNoOfCoins(arr, 5);
    }

    public static void printArr(int[] arr) {

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static int minNoOfCoins(int[] coins, int amount) {

        int[] memoizedArr = new int[amount + 1];
        Arrays.fill(memoizedArr, amount + 1);
        memoizedArr[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {
                if (i >= coin)
                    memoizedArr[i] = Math.min(memoizedArr[i], 1 + memoizedArr[i - coin]);
            }
        }

        printArr(memoizedArr);

        return 0;
    }

}

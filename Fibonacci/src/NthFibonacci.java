import java.util.ArrayList;
import java.util.Scanner;

public class NthFibonacci {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Long> fibonacciNums = new ArrayList();
        int i = 2;
        fibonacciNums.add(0, (long) 0);
        fibonacciNums.add(1, (long) 1);

        while (i <= n) {

            fibonacciNums.add(i, (fibonacciNums.get(i - 1) + fibonacciNums.get(i - 2))%10);
            i++;

        }
        System.out.println(fibonacciNums.get(n));
    }
}



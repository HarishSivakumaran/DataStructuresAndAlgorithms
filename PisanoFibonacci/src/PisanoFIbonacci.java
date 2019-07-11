import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PisanoFIbonacci {

  static   ArrayList<Integer> fibonacciNoList = new ArrayList<Integer>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nthFibonacci = scanner.nextInt();
        int modulusOfN = scanner.nextInt();
        int period = getPeriod(modulusOfN);

        System.out.println(fibonacciNoList.get(nthFibonacci%period));

    }

    public static int getPeriod(int m) {

        fibonacciNoList.add(0, 0);
        fibonacciNoList.add(1, 1);
        int period = -1;

        for (int i = 0; i < m * m; i++) {
            fibonacciNoList.add(2 + i, ((fibonacciNoList.get(i) + fibonacciNoList.get(i + 1)) % m));
            if ((fibonacciNoList.get(0).equals(fibonacciNoList.get(i + 1))) && (fibonacciNoList.get(1).equals(fibonacciNoList.get(i + 2)))) {

                period = i + 1;

                if (verifyPeriod(period, m)) {
                    break;
                }

            }
        }
        return period;

    }

    public static boolean verifyPeriod(int period, int m) {

        boolean isPeriod = true;

        for (int i = 2; i < period; i++) {
            fibonacciNoList.add(period + i - 2, (fibonacciNoList.get(i + period - 3) + fibonacciNoList.get(i + period - 4) % m));

            if (fibonacciNoList.get(i).equals(fibonacciNoList.get(i + period))) {
                continue;
            } else {
                isPeriod = false;
                break;
            }

        }
        return isPeriod;

    }
}

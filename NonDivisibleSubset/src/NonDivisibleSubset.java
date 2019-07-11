import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;

public class NonDivisibleSubset {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] arrNum = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count=0;

        int[] remArr = new int[nk[1]+1];

        for (int i = 0; i < arrNum.length; i++) {

          remArr[arrNum[i] % nk[1]]+=1;


        }






    }
}

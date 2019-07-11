import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Proj10 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nm =bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

        String[] a =bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

        String[] b =bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

        int[] arrA = Arrays.stream(a).mapToInt(Integer::parseInt).toArray();

        int[] arrB = Arrays.stream(b).mapToInt(Integer::parseInt).toArray();

        int n = arrB[0]/arrA[arrA.length-1];


        int i = 1;

        int countA ;
        int countB ;
        int finalCount =0;

        while(i <= n){
            countA=0;

            countB=0;

            int m = 0;
            while(m < arrA.length){
                int v =( arrA[arrA.length-1]*i )% arrA[m];
                if(v == 0){
                    countA++;
                }else {
                    break;
                }
                m++;
            }

            int p=0;
            if(countA == arrA.length){
                while(p < arrB.length){
                    int v = arrB[p] % (arrA[arrA.length-1]*i);
                    if(v == 0){
                        countB++;
                    }else{
                        break;
                    }
                    p++;
                }
            }

            if(countB == arrB.length){
                finalCount++;
            }
            i++;
        }


System.out.println(finalCount);

    }

}

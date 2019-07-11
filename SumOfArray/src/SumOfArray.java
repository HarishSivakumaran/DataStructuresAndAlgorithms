import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfArray {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");
        String[] sValues = bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

        int[] iValues = Arrays.stream(sValues).mapToInt(Integer::parseInt).toArray();
        int[] ink = Arrays.stream(nk).mapToInt(Integer::parseInt).toArray();

        int k = ink[1];

        int count = 0 ;

        for(int i = 0 ; i< iValues.length ;i++) {

            for(int j =i+1 ; j<iValues.length;j++){

                if((iValues[i]+iValues[j])%k == 0)
                    count++;

            }

        }

        System.out.println(count);
        }
    }


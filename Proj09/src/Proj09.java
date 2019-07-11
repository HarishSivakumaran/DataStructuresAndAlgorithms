import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Proj09 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] posVal = bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

        int[]  posValues = Arrays.stream(posVal).mapToInt(Integer::parseInt).toArray();

        if((posValues[3]-posValues[1] != 0)){

            int n = (posValues[0] - posValues[2]) % (posValues[3] - posValues[1]);
            int r = (posValues[0] - posValues[2]) / (posValues[3] - posValues[1]);


            if (r > 0) {
                if (n == 0) {
                    System.out.println("YES");

                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }else {
            System.out.println("NO");
        }



    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BasketBallrecords {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(bufferedReader.readLine());

        String[] scores = bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

        int[] iScores = Arrays.stream(scores).mapToInt(Integer::parseInt).toArray();

        int max=iScores[0];
        int min=iScores[0];

        int maxRec =0;
        int minRec =0;

        for (int i = 1; i < iScores.length; i++) {

            if(iScores[i]>max) {
                maxRec++;
                max=iScores[i];
            }

            if(iScores[i]<min) {
                minRec++;
                min=iScores[i];
            }

        }

        System.out.println(maxRec+" "+minRec);
    }
}

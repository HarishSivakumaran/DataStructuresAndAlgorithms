import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CarFuelFilling {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int l = 400;
        int[] fillingPoints = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int currentFillingPoint = 0;
        int lastFillingPoint;
        int n = fillingPoints.length;
        int noOfRefills = 0;

        while (currentFillingPoint < n ) {

            lastFillingPoint = currentFillingPoint;
            while ((currentFillingPoint < n - 1) && (fillingPoints[currentFillingPoint + 1] - fillingPoints[lastFillingPoint] <= l)) {
                currentFillingPoint++;
            }

            if (currentFillingPoint == n-1) {
                break;
            }

            if (currentFillingPoint == lastFillingPoint) {
                System.out.println("cant reach the next fueling station");
                break;
            }

            if (currentFillingPoint > lastFillingPoint) {
                noOfRefills++;
            }
        }

        System.out.println(noOfRefills);

    }
}

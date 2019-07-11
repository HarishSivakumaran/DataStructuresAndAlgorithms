import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SweepLineAlgorrithm {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] noOfSegmentsAndPoints = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt((String a) ->
                Integer.parseInt(a)
        ).toArray();

        PointAndPosition[] segements = new PointAndPosition[noOfSegmentsAndPoints[0]];
        PointAndPosition[] points = new PointAndPosition[noOfSegmentsAndPoints[1]];

        for(int i=0;i<noOfSegmentsAndPoints[0];i++){
           int[] pair = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        PointAndPosition[] segements = getSegmentsArray(pair);}

    }
    static PointAndPosition[] getSegmentsArray(int[] pair){

    }

}

class PointAndPosition {
    String position;
    int point;

    PointAndPosition(String position, int value) {

        this.point = point;
        this.position = position;
    }
}

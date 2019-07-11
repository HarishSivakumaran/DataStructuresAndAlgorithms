import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MagicMatrix {

    public static void main(String[] args) throws IOException {

        int[][] givenArr = new int[3][3];

        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i<3;i++){

for(int j = 0 ;j<3;j++){

    givenArr[i][j]=scanner.nextInt();
}
        }

        int[][][] magicArrPerm = {{{8,3,4},{1,5,9},{6,7,2}},
                                 {{4,3,8},{9,5,1},{2,7,6}},
                                  {{8,1,6},{3,5,7},{4,9,2}},
                {{6,1,8},{7,5,3},{2,9,4}},
                {{4,9,2},{3,5,7},{8,1,6}},
                {{2,9,4},{7,5,3},{6,1,8}},
                {{3,5,7},{4,9,2},{8,1,6}},
                {{7,5,3},{2,9,4},{6,1,8}},
                {{3,5,7},{8,1,6},{4,9,2}},
                {{7,5,3},{6,1,8},{2,9,4}}};

        int min = 100;
        for (int i = 0; i < 8; i++) {
            int diff = 0;
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    diff += Math.abs(magicArrPerm[i][x][y] - givenArr[x][y]);
                }
            }
            if (diff < min)
                min = diff;
        }
        System.out.println(min);
















    }

}

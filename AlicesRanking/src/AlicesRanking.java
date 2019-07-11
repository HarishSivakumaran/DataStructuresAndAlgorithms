import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlicesRanking {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int[] scoreCard = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int aliceN = Integer.parseInt(bufferedReader.readLine());

        int[] aliceScores = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        int l =0;


        for(int i=0 ;i<scoreCard.length;i++){

            for(int k=0;k<(scoreCard.length-1);k++){

                if(scoreCard[k]>scoreCard[k+1]){
                    int temp = scoreCard[k+1];
                    scoreCard[k+1] = scoreCard[k];
                    scoreCard[k]=temp;
                }else if(scoreCard[k] == scoreCard[k+1]){
                    scoreCard[k]=-10;
                }
            }
            int y=0;
            while(y<=i) {
                if (aliceScores[l] >= scoreCard[scoreCard.length - 1 - y]) {
                    System.out.println(y + 1);
                    l++;
                    i = 0;
                    break;
                }
                y++;


            }
            if(l == aliceScores.length)
                break;


        }

//        for (int i = 0; i < aliceScores.length; i++) {
//
//            for(int j = 0;j<scoreCard.length;j++){
//
//                if(aliceScores[i] >= scoreCard[j]){
//                    System.out.println(j+1);
//                    break;
//                }
//            }

 //       }

    }
}

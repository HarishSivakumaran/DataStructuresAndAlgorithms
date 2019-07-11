import java.io.*;
import java.util.Arrays;

public class BirdsMigration {
    public  static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(bufferedReader.readLine());

        int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] count = new int[]{0,0,0,0,0};


        for(int i = 0; i<arr.length;i++) {

            switch (arr[i]){
                case 1 : count[0]++;
                break;
                case 2 : count[1]++;
                    break;
                case 3 : count[2]++;
                    break;
                case 4 : count[3]++;
                    break;
                case 5 : count[4]++;
                    break;
            }
        }

        int max =0;

        int k =0;

        for(int i=0 ; i<count.length;i++){

            max= count[i];

             k =0;

            for(int j = i+1 ; j<count.length;j++){

                if(count[j]>max){

                        k++;
                        break;

                }

            }
            if(k == 0){
                System.out.println(i+1);

                break;}

        }

        }

    }


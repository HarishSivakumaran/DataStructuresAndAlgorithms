import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Proj08 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));

        String[] st = bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

        String[] ab = bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

        String[] mn = bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

        String[] appleDist = bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

        String[] orangeDist = bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

        int[] orangeArray = Arrays.stream(orangeDist).mapToInt(Integer::parseInt).toArray();

        int[] appleArray= Arrays.stream(appleDist).mapToInt(Integer::parseInt).toArray();

        int[] stA= Arrays.stream(st).mapToInt(Integer::parseInt).toArray();

        int[] abA= Arrays.stream(ab).mapToInt(Integer::parseInt).toArray();

        int[] mnA= Arrays.stream(mn).mapToInt(Integer::parseInt).toArray();

        int orangeOnHouse = 0;

        int appleOnHouse = 0;

        for(int i=0 ;i<orangeArray.length;i++){
            orangeArray[i] =orangeArray[i]+abA[1];
            if(orangeArray[i] >= stA[0] && orangeArray[i]<=stA[1]){
                orangeOnHouse++;
            }

        }

        for(int i=0 ;i<appleArray.length;i++){
            appleArray[i] =appleArray[i]+abA[0];
            if(appleArray[i] >= stA[0] && appleArray[i]<=stA[1]){
                appleOnHouse++;
            }
        }


        System.out.println(appleOnHouse);
        System.out.println(orangeOnHouse);



    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Proj07 {

   static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int[] marks = new int[n];

        for(int i = 0 ;i<n;i++){

            marks[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for(int i = 0 ;i<n;i++) {

        if(marks[i] > 37){

            int tempQ = marks[i]/10;
            int tempR = marks[i]%10;

            if(tempR>5){
                tempR=10;
            }else{
                tempR=5;
            }

            tempQ = tempQ*10+tempR;

            if(tempQ - marks[i] <3){
                marks[i] = tempQ;
            }

        }

        }
        for(int i = 0 ;i<n;i++) {

            System.out.println(marks[i]);

        }
    }


    public void somethn() throws IOException{

      String a =  bufferedReader.readLine();
    }
}

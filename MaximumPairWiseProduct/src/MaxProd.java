import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxProd {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


          String n = bufferedReader.readLine();

        long[] nos = Arrays.stream(bufferedReader.readLine().trim().replaceAll("\\s+"," ").split(" ")).mapToLong(Long::parseLong).toArray();


    for(int i=0;i<2;i++){

        for(int j =0 ;j<nos.length-1;j++){

            if(nos[j]>nos[j+1]){
                long temp = nos[j+1];
                nos[j+1]= nos[j];
                nos[j]=temp;
            }
        }

    }

    System.out.println(nos[nos.length-1]*nos[nos.length-2]);

    }
}

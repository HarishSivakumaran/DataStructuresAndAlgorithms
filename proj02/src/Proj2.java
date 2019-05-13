import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Proj2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(bufferedReader.readLine());

        String[] a;

        float pos=0;
        float zero=0;
        float neg=0;

        a = bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

        for(int i =0;i<length;i++){

          float b =   Integer.parseInt(a[i])>0 ? pos++ : 0;

           b=  Integer.parseInt(a[i])<0 ? neg++ : 0;

            b = Integer.parseInt(a[i])==0 ? zero++ : 0;
        }


        System.out.println(String.format("%6f",pos/length));
        System.out.println(String.format("%6f",neg/length));
        System.out.println(String.format("%6f",zero/length));




    }
}

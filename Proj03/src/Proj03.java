import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Proj03 {

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int len = 0;
        try {
             len = Integer.parseInt(bufferedReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

        int rows = len;

        while(rows>0) {

            for(int i=1;i<=len;i++) {

               String a = i < rows ? " ": "#";

               System.out.print(a);

            }

            System.out.print("\n");
            rows--;
        }
        }


    }



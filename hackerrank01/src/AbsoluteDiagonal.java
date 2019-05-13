import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AbsoluteDiagonal {

    public AbsoluteDiagonal() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String[]> matrix = new ArrayList<String[]>();
        String s;



        String[] arr = new String[]{};
        while(true){
            String a =bufferedReader.readLine();
            if(a.length()>0) {
                arr = a.replaceAll("\\s+", " ").split(" ");
                matrix.add(arr);
            }
            else
            {
                break;
            }


        }

        int diag1=0;

        for(int i = 0; i<matrix.size(); i++){

            String[] smtn = matrix.get(i);
            diag1+=Integer.parseInt(smtn[i]);
            System.out.println(diag1);

        }

        int diag2=0;

        for(int i = 0; i<matrix.size(); i++){

            String[] smtn = matrix.get(i);
            diag2+=Integer.parseInt(smtn[            matrix.size()-1-i
                    ]);
            System.out.println(diag2);

        }

        System.out.println(Math.abs(diag1-diag2));

    }
}

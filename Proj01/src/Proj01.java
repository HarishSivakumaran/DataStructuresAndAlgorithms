import java.io.*;
import java.util.ArrayList;

public class Proj01 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int order = Integer.parseInt(bufferedReader.readLine());

        int count = order;


        String[] row = new String[]{};

        ArrayList<String[]> mMatrix=new ArrayList<String[]>();

        while(order!=0){

            row = bufferedReader.readLine().split(" ");

            mMatrix.add(row);

            order--;

        }


        int diag1=0;
        int diag2=0;

        for( int i=0; i < count; i++){
            row = mMatrix.get(i);
            diag1+=Integer.parseInt(row[i]);
        }


        for( int i=0; i< count; i++){
            row = mMatrix.get(i);
            diag2+=Integer.parseInt(row[count-1-i]);
        }

        System.out.println(Math.abs(diag1-diag2));

    }
}

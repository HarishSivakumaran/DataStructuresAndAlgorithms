import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Proj04 {

    public static void main(String[] args){

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrNum= new String[]{};
        try {
            arrNum = bufferedReader.readLine().replaceAll("\\s+", " ").split(" ");
        }catch (IOException e){
            e.printStackTrace();
        }

        long[] arrN = new long[5];

        for(int i=0; i<arrNum.length; i++) {

            arrN[i]=Long.parseLong(arrNum[i]);

        }

        int length = arrNum.length-1;
        int k =length;

        while(k != 0) {
            for (int i = 0; i < length; i++) {

                if (arrN[i] > arrN[i + 1]) {
                    long temp;
                    temp = arrN[i];
                    arrN[i] = arrN[i + 1];
                    arrN[i + 1] = temp;

                }

            }
            k--;
        }

        long x=arrN[1]+arrN[2]+arrN[3]+arrN[4];

     System.out.println(arrN[0]+arrN[1]+arrN[2]+arrN[3] + " " + x);




        }

    }


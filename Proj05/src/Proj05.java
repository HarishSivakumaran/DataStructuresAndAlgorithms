import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Proj05 {
    public static void main (String[] args){

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in) );

        Long age;
        String[] candles = new String[]{};
        try{
             age = Long.parseLong(bufferedReader.readLine());
             candles = bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");
        }catch(IOException e){
            e.printStackTrace();
        }

        ArrayList<Long>  candNum = new ArrayList<Long>();



        for(Integer i = 0 ; i < candles.length;i++) {

           candNum.add(Long.parseLong(candles[i]));

           System.out.println(candNum.get(0));


        }

        int j = candNum.size() - 1;




            for(int i = 0 ;i <j;i++){

                if(candNum.get(i)>candNum.get(i+1)){

                    Long temp = new Long(0);
                    temp = candNum.get(i);
                    candNum.set(i,candNum.get(i+1));
                    candNum.set(i+1,temp);

                }

            }



        long count=0;


        for(int i = 0 ;i<candles.length;i++){

            if(candNum.get(candNum.size() - 1).equals(candNum.get(i))) {
                count++;

            }
        }

        System.out.println(count);


    }
}

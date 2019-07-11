import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Proj06 {

    public static void main(String[] args){

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String mTime = "";
        Date time;
        String output= "";
        try {
             mTime = bufferedReader.readLine();
        }catch (IOException e ){
            e.printStackTrace();
        }

        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ssaa");
        DateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");

        try{

            time = dateFormat.parse(mTime);
            output=outputFormat.format(time);

        }catch(ParseException p){
            p.printStackTrace();
        }

        System.out.println(output);
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class AmazonOnline {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] eq = bufferedReader.readLine().split("[\\+\\-\\*\\/\\=]");

        int total = 0;
        boolean isxSeen = false;

        for(String a : eq){
            if((Pattern.matches("\\d",a))&&(!isxSeen)){
                total+=Integer.parseInt(a);
            }else if(a.equals("x")){
                isxSeen = true;
            }else{
                total= -total +Integer.parseInt(a);

            }



        }

        System.out.println(total);


    }


}

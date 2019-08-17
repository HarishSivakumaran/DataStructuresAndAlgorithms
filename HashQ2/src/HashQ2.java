import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;

public class HashQ2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(bufferedReader.readLine());

        int n = Integer.parseInt(bufferedReader.readLine());

        ArrayList<String>[] arr = new ArrayList[m];

        for (int i=0;i<m;i++){
            arr[i] = new ArrayList<String>();
        }
      for (int i = 0; i < n; i++) {

            String[] commands = bufferedReader.readLine().split(" ");ArrayList<String> a;
            if(!Pattern.matches("[0-9]+",commands[1])) {
               a =arr[(int) (hashFunction(commands[1])%m)];
            }else{
                 a =arr[Integer.parseInt(commands[1])];
            }
            switch (commands[0]){
                case "add" : a.add(commands[1]);
                break;
                case "del" : while(a.contains(commands[1])){
                    a.remove(commands[1]);
                }
                break;
                case "check":
                    for(int k =a.size()-1;k>=0;k-- ){
                    System.out.print(a.get(k)+" ");
                }
                    System.out.println();
                break;
                case "find": if(arr[(int) (hashFunction(commands[1])%m)].contains(commands[1])){
                    System.out.println("yes");
                }else{
                    System.out.println("no");

                }
                break;
                default:break;
            }

        }
      



    }


    public static Long hashFunction(String str) {

        Long hash = new Long(0);
        Long x = new Long(263);
        Long p = new Long(1000000007);

        for (int i = 0; i < str.length(); i++) {
            hash =  new Long((long) ((hash +(str.charAt(i) * Math.pow(x, i))) % p));

        }
        return hash;

    }
}

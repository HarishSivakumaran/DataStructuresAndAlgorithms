import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class HashQ1 {

    public static void main(String[] args) throws IOException {

        Hashtable<Long,String> phoneBook = new Hashtable<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0 ; i<n;i++){

            String[] commands = bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

            switch (commands[0]){
                case "add" : phoneBook.put(Long.parseLong(commands[1]),commands[2]);
                break;

                case "find": if(phoneBook.containsKey(Long.parseLong(commands[1]))){
                    System.out.println(phoneBook.get(Long.parseLong(commands[1])));
                }else{
                    System.out.println("not found");
                }
                break;

                case "del" : if(phoneBook.containsKey(Long.parseLong(commands[1]))){
                    phoneBook.remove(Long.parseLong(commands[1]));
                }
                break;
                default:break;

            }
        }
    }
}

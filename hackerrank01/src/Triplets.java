//import java.io.*;
//import java.util.ArrayList;
//
//public class Triplets {
//
//    public static void main (String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//         File hrank = new File("/home/hrank.txt");
//
//        BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter("/home/hrank.txt")));
//
//
//         String[] b =bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");
//
//        // System.out.println(bufferedReader.readLine().replaceAll("\\s+"," ").split(" "));
//
//        String[] c = (bufferedReader.readLine().replaceAll("\\s+"," ").split(" "));
//
//        int alice=0;
//        int bob=0;
//
//        for(int i =0;i<c.length;i++){
//
//            if (Integer.parseInt(b[i]) < Integer.parseInt(c[i])) {
//                bob ++;
//            }
//            if (Integer.parseInt(b[i]) > Integer.parseInt(c[i])) {
//                alice++;
//            }
//
//
//        }
//
//        System.out.println(alice + " " + bob);
//
//
//
//
//    }
//}

import java.io.*;
        import java.util.ArrayList;


public class Triplets {

    public static void main (String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));



        String[] b =bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

        // System.out.println(bufferedReader.readLine().replaceAll("\\s+"," ").split(" "));

        String[] c = (bufferedReader.readLine().replaceAll("\\s+"," ").split(" "));

        int alice=0;
        int bob=0;

        for(int i =0;i<c.length;i++){

            if (Integer.parseInt(b[i]) < Integer.parseInt(c[i])) {
                bob ++;
            }
            if (Integer.parseInt(b[i]) > Integer.parseInt(c[i])) {
                alice++;
            }


        }

        File hrank = new File("/home/harish/hrank.txt");
        FileWriter fileWriter = new FileWriter("Abc.txt");


        BufferedWriter bufferedWriter= null;
        try {
            bufferedWriter = new BufferedWriter(fileWriter);

            System.out.println("hello");

            if(!hrank.exists()){
                hrank.createNewFile();
                System.out.println("file doesnt exist");

            }

        } catch (IOException e) {
            e.printStackTrace();
            bufferedWriter.write(e.toString(),0,e.toString().length());
        } finally {

            System.out.println("here");
//            bufferedWriter.write(23232222);
//            bufferedWriter.write(alice);
//            bufferedWriter.write("  ",0,2);
//            bufferedWriter.write(bob);

           // bufferedWriter.write("hello world");
            bufferedWriter.write(alice);
            bufferedWriter.write(" ");
            bufferedWriter.write(bob);


        }


        bufferedWriter.close();



        System.out.println(alice + " " + bob);

        AbsoluteDiagonal absoluteDiagonal = new AbsoluteDiagonal();




    }
}

//import java.io.*;
//        import java.math.*;
//        import java.security.*;
//        import java.text.*;
//        import java.util.*;
//        import java.util.concurrent.*;
//        import java.util.regex.*;
//
//public class Solution {
//
//    // Complete the compareTriplets function below.
//    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
//
//
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        List<Integer> a = new ArrayList<>();
//
//        for (int i = 0; i < 3; i++) {
//            int aItem = Integer.parseInt(aItems[i]);
//            a.add(aItem);
//        }
//
//        String[] bItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        List<Integer> b = new ArrayList<>();
//
//        for (int i = 0; i < 3; i++) {
//            int bItem = Integer.parseInt(bItems[i]);
//            b.add(bItem);
//        }
//
//        List<Integer> result = compareTriplets(a, b);
//
//        for (int i = 0; i < result.size(); i++) {
//            bufferedWriter.write(String.valueOf(result.get(i)));
//
//            if (i != result.size() - 1) {
//                bufferedWriter.write(" ");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorial {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String n = bufferedReader.readLine();
        ExtraLongFactorial extraLongFactorial = new ExtraLongFactorial();
        extraLongFactorial.factorial(n);
    }

    public void factorial(String n){

    int k = Integer.parseInt(n);
        BigInteger fact = new BigInteger("1");
        BigInteger n1 = new BigInteger(n);
        BigInteger a =new BigInteger("1");

        while (k!=0){
            fact = fact.multiply(n1);
            n1=n1.subtract(a);
            k--;
        }
        System.out.println(fact);


    }
}

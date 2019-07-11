import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BirthdayChoc implements some {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        String[] sChocSq = bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

        String[] sDayMon = bufferedReader.readLine().replaceAll("\\s+"," ").split(" ");

        int[] iChocSq = Arrays.stream(sChocSq).mapToInt(Integer::parseInt).toArray();

        int iDay = Integer.parseInt(sDayMon[0]);

        int iMon = Integer.parseInt(sDayMon[1]);

        int count= 0 ;

        int j = 0;
        while(j<=(iChocSq.length-iMon)) {

            int sum =0;

            for (int i = j; i < iMon+j ; i++) {


                sum+=iChocSq[i];

            }

            if(sum == iDay)
                count++;


            j++;
        }

        System.out.println(count);

BirthdayChoc birthdayChoc = new BirthdayChoc();
birthdayChoc.hello();
    }

    @Override
    public void a() {
b();
    }

    @Override
    public void b() {
    }

    public void hello(){
        System.out.println("hello user");
        a();

    }
}

 interface  some{
    void a();
    void b();
}

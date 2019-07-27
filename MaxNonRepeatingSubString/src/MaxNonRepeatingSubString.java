import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class MaxNonRepeatingSubString {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bufferedReader.readLine().split("");

        System.out.println(findMaxsubstringLen(str));

    }

    public static int findMaxsubstringLen(String[] strArr) {

        int startIndex = 0;
        int maxLength = 0;
        Hashtable<String, Integer> charLastSeen = new Hashtable<>();

        for (int i = 0; i < strArr.length; i++) {
            if (!(charLastSeen.containsKey(strArr[i]))) {
                charLastSeen.put(strArr[i], i);
            } else if (charLastSeen.containsKey(strArr[i]) && (charLastSeen.get(strArr[i]) < startIndex)) {
                charLastSeen.put(strArr[i], i);
            } else if (charLastSeen.containsKey(strArr[i]) && (charLastSeen.get(strArr[i]) > startIndex)) {
                int length = i - startIndex;
                if (length > maxLength) {
                    maxLength = length;
                }
                startIndex = charLastSeen.get(strArr[i])+1;
                charLastSeen.put(strArr[i],i);
            }
        }

        return maxLength;
    }
}

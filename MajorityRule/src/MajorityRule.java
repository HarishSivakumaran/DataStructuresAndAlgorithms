import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class MajorityRule {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(bufferedReader.readLine().replaceAll("\\s+", " ").split(" ")).mapToInt(Integer::parseInt).toArray();

        HashMap<Integer, Integer> filterMap = new HashMap<>();

        for (int i : array) {
            if (!filterMap.containsKey(i)) {
                filterMap.put(i, 1);
            } else {
                filterMap.put(i, filterMap.get(i) + 1);
            }
        }

        filterMap.forEach((Integer key, Integer value) -> {
            System.out.println(key+" "+value);
            return ;
                }
        );

    }
}

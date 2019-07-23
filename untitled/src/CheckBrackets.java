import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Pattern;

public class CheckBrackets {

    static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException {

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] string = bufferedReader.readLine().split("");

        new CheckBrackets().checkBalance(string);

    }

    public void checkBalance(String[] string) {

        Stack<BracketAndIndex> charStack = new Stack<BracketAndIndex>();
        int i = -1;
        boolean balanced = true;
        BracketAndIndex error = new BracketAndIndex("", 0);

        for (String bracket : string) {
            i++;
            if (bracket.equals("[") || bracket.equals("{") || bracket.equals("(")) {
                charStack.push(new BracketAndIndex(bracket, i));
            } else if ((!charStack.empty()) && (charStack.peek().bracket.equals(findPair(bracket)))) {
                charStack.pop();
            } else if (Pattern.matches("[^{}()\\[\\]]", bracket.toLowerCase())) {
                continue;
            } else {
                balanced = false;
                error = new BracketAndIndex(bracket, i);
                break;
            }

        }
        if (balanced && charStack.empty()) {
            System.out.println("Success");
        } else if (!balanced) {
            System.out.println(error.index + 1);
        } else {
            System.out.println(charStack.peek().index + 1);
        }
    }

    public static String findPair(String string) {

        if (string.equals("]")) {
            return "[";
        }
        if (string.equals("}")) {
            return "{";
        }
        if (string.equals(")")) {
            return "(";
        }
        return "";
    }

    public class BracketAndIndex {
        String bracket;
        int index;

        BracketAndIndex(String bracket, int index) {

            this.bracket = bracket;
            this.index = index;

        }
    }

}



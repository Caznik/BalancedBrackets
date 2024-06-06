package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

class Result {


    public static String isBalanced(String s) {
    	Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return "NO";
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return "NO";
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return "NO";
                    }
                    break;
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

}

public class BalancedBracketsMain {
    public static void main(String[] args) throws IOException {
    	File file = new File("test.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

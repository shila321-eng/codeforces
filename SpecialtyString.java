//https://codeforces.com/problemset/problem/2200/C

import java.util.Scanner;
import java.util.Stack;

public class SpecialtyString {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                String s = sc.next();

                Stack<Character> stack = new Stack<>();

                for (int i = 0; i < n; i++) {
                    char currentChar = s.charAt(i);

                    if (!stack.isEmpty() && stack.peek() == currentChar) {
                        stack.pop();
                    } else {
                        stack.push(currentChar);
                    }
                }

                if (stack.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
}

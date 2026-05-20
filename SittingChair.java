//https://codeforces.com/problemset/problem/2210/B
import java.util.Scanner;

public class SittingChair {

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        int p[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        int minmark = n + 1;
        int currentSitting = 0;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (i >= minmark) {
                break;
            }
            currentSitting++;
            if (p[i] > i) {
                minmark = Math.min(minmark, p[i]);
            }
            ans = Math.max(ans, currentSitting);

        }
        System.out.println(ans);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {

            int t = sc.nextInt();

            while (t-- > 0) {

                solve(sc);

            }

        }
        sc.close();
    }
}

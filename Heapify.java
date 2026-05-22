
import java.util.Scanner;

public class Heapify {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int permutation[] = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    permutation[i] = sc.nextInt();
                }

                boolean isPossible = true;

                for (int i = 1; i <= n; i++) {
                    int indexTrack = i;
                    int numberTrack = permutation[i];

                    while (indexTrack % 2 == 0) {
                        indexTrack = indexTrack / 2;
                    }

                    while (numberTrack % 2 == 0) {
                        numberTrack = numberTrack / 2;
                    }

                    if (indexTrack != numberTrack) {
                        isPossible = false;
                        break;
                    }
                }

                if (isPossible) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
}

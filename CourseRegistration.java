//https://codeforces.com/problemset/problem/2216/A
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CourseRegistration {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int capacityLimits[] = new int[k];
            int wishLevels[] = new int[n];
            for (int i = 0; i < k; i++) {
                capacityLimits[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                wishLevels[i] = sc.nextInt();
            }

            HashMap<Integer, Integer> wishLevelCount = new HashMap<>();

            for (int wishLevel : wishLevels) {
                wishLevelCount.put(wishLevel, wishLevelCount.getOrDefault(wishLevel, 0) + 1);
            }

            List<Integer> operations = new ArrayList<>();
            for (int op = 0; op < 1000; op++) {
                boolean did_operation = false;
                for (int course = 0; course < n; course++) {
                    int currentWishLevel = wishLevels[course];

                    if (currentWishLevel == k + 1) {
                        continue;
                    }

                    wishLevelCount.put(currentWishLevel + 1, wishLevelCount.getOrDefault(currentWishLevel + 1, 0));
                    int nextWishLevelCount = wishLevelCount.getOrDefault(currentWishLevel + 1, 0);

                    if (nextWishLevelCount < capacityLimits[currentWishLevel - 1]) {
                        wishLevels[course] = currentWishLevel + 1;

                        wishLevelCount.put(currentWishLevel, wishLevelCount.getOrDefault(currentWishLevel, 0));
                        wishLevelCount.put(currentWishLevel, wishLevelCount.getOrDefault(currentWishLevel, 0) - 1);

                        // wishLevelCount.put(currentWishLevel + 1, nextWishLevelCount + 1);
                        operations.add(course + 1);
                        did_operation = true;
                        break;
                    }
                }
                if (!did_operation) {
                    break;
                }
            }

            boolean allAreEqual = true;
            for (int wishLevel = 0; wishLevel < wishLevels.length - 1; wishLevel++) {
                if (wishLevels[wishLevel] != wishLevels[wishLevel + 1]) {
                    allAreEqual = false;
                }
            }

            if (!allAreEqual) {
                System.out.println("-1");
            } else {
                System.out.println(operations.size());
                for (int operation : operations) {
                    System.out.print(operation + " ");
                }
                System.out.print("\n");
            }
        }
    }
}

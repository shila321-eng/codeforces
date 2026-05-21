
import java.util.Scanner;

public class FindingMaximumIndices {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Read how many test cases total
        int t = sc.nextInt();

        while (t-- > 0) {
            // Read the array size n
            int n = sc.nextInt();
            int arr[] = new int[n];

            // Loop 1: Fill up the array safely from 0 to n-1
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Loop 2: Process every index 'i'
            for (int i = 0; i < n; i++) {
                int strictlySmaller = 0;
                int strictlyLarger = 0;

                // Look at elements to the right of 'i'
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[i]) {
                        strictlySmaller++;
                    } else if (arr[j] > arr[i]) {
                        strictlyLarger++;
                    }
                }

                // Find which option gives more valid indices
                int maxCount = Math.max(strictlySmaller, strictlyLarger);

                System.out.print(maxCount + " ");
            }

            // Break to a clean new line for the next test case
            System.out.println();
        }

        sc.close();
    }
}

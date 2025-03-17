//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        boolean[] prev = new boolean[sum + 1];
        boolean[] curr = new boolean[sum + 1];

        // Mark prev[0] = true as it is true to
        // make sum = 0 using 0 elements
        prev[0] = true;

        // Fill the subset table in bottom-up
        // manner
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < arr[i - 1]) {
                    curr[j] = prev[j];
                }
                else {
                    curr[j]
                        = prev[j] || prev[j - arr[i - 1]];
                }
            }

            // Update prev to be the current row
            System.arraycopy(curr, 0, prev, 0, sum + 1);
        }
        return prev[sum];
    }
}
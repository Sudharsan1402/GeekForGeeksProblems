//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int arr[] = new int[input.length];

            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);

            // Read the integer k
            int k = Integer.parseInt(br.readLine());

            // Call the solution function
            Solution obj = new Solution();
            System.out.println(obj.maxProfit(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int maxProfit(int prices[], int k) {
        // code here
        int n = prices.length;
        if (n == 0 || k == 0)
            return 0;
        int[][] curr = new int[k+1][2];
        int[][] next = new int[k+1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int l = 1; l <= k; l++) {
                curr[l][1] = Math.max(-prices[i] + next[l][0], next[l][1]);
                curr[l][0] = Math.max(prices[i] + next[l-1][1], next[l][0]);
            }
            for (int l = 0; l <= k; l++) {
                next[l][0] = curr[l][0];
                next[l][1] = curr[l][1];
            }
        }
      
        
        return curr[k][1]; 
    }
}
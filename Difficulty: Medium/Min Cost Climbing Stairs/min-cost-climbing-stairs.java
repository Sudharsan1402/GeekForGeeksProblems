//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = str.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            int res = sln.minCostClimbingStairs(arr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        int n = cost.length;
        if(n == 1){
            return cost[0];
        }
        
        int prev1 = cost[1];
        int prev2 = cost[0];
        for(int i=2;i<n;i++){
            int curr = cost[i]+Math.min(prev1,prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1,prev2);
    }
};
//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = 1; j <= sum; j++) {
                int take = Integer.MAX_VALUE, noTake = Integer.MAX_VALUE;
                if (j - coins[i] >= 0 && coins[i] > 0) {
                    take = dp[j - coins[i]];
                    if (take != Integer.MAX_VALUE) take++;
                }
                if (i + 1 < coins.length)
                    noTake = dp[j];
                dp[j] = Math.min(take, noTake);
            }
        }
        return dp[sum] != Integer.MAX_VALUE ? dp[sum] : -1;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minCoins(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends
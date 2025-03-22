//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    
    static int maxValTab(int x, int y, int[] arr) {
        int n = arr.length;
        int prev2 = arr[x];
        int prev1 = Math.max(arr[x], arr[x + 1]);
        for (int j = x + 2; j <= y; j++) {
            int take = arr[j] + prev2;
            int noTake = prev1;
            
            int curr = Math.max(take, noTake);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }

    int maxValue(int[] arr) {
        // code here
         int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
    
        int ans = 0;
        ans = Math.max(ans, maxValTab(0, n - 2, arr));
        ans = Math.max(ans, maxValTab(1, n - 1, arr));
        
        return ans;
      
    }
}

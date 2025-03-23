//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int countWays(String digits) {
        // code here
        int n = digits.length();
        if (n == 0 || digits.charAt(0) == '0') {
            return 0;
        }

        int prev1 = 1, prev2 = 0;

        for (int i = 1; i <= n; ++i) {

            int current = 0;
            if (digits.charAt(i - 1) != '0') {
                current += prev1;
            }

            if (i > 1) {
                int twoDigit
                    = (digits.charAt(i - 2) - '0') * 10
                      + (digits.charAt(i - 1) - '0');
                if (twoDigit >= 10 && twoDigit <= 26) {
                    current += prev2;
                }
            }

            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int isCircle(String arr[]) {
        // code here
         List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<26;i++)   list.add(new ArrayList<>());
        int dp[] = new int[26];
        for(String s:arr){
            int a = s.charAt(0)-'a', b = s.charAt(s.length()-1)-'a';
            dp[a]++;
            dp[b]++;
            list.get(a).add(b);
        }
        
        for(int i:dp){
            if(i%2==1)  return 0;
        }
        
        boolean vis[] = new boolean[26];
        solve(arr[0].charAt(0)-'a',list,vis);
        
        for(int i=0;i<26;i++){
            if(dp[i]>0 && !vis[i])  return 0;
        }
        
        return 1;
    }
    
    void solve(int i,List<List<Integer>> list,boolean vis[]){
        if(vis[i])  return;
        
        vis[i] = true;
        for(int nbr:list.get(i)){
            solve(nbr,list,vis);
        }
    }
}
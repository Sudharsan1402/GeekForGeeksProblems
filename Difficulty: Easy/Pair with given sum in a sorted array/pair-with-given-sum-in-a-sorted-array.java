//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int n = arr.length;
        int left = 0, right = n-1;
        int count = 0;
        while(left < right){
            int currSum = arr[left]+arr[right];
            if(currSum < target){
                left++;
            }else if(currSum > target){
                right--;
            }else{
                int cnt1 = 0, cnt2 = 0;
                int ele1 = arr[left], ele2 = arr[right];
                while(left<=right && ele1==arr[left]){
                    left++;
                    cnt1++;
                }
                while(left<=right && ele2==arr[right]){
                    right--;
                    cnt2++;
                }
                if(ele1 == ele2){
                    count += cnt1*(cnt1-1)/2;
                }
                else{
                    count += cnt1*cnt2;
                }
            }
        }
        return count;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends
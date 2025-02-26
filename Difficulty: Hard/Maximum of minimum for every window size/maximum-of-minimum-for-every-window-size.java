//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n,0));
        Stack<Integer> s = new Stack<>();
        
        ArrayList<Integer> lenArr = new ArrayList<>(Collections.nCopies(n, 0));
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                int top = s.pop();
                int windowSize = s.isEmpty() ? i : i - s.peek() - 1;
                lenArr.set(top, windowSize);
            }
            s.push(i);
        }
        
        while (!s.isEmpty()) {
            int top = s.pop();
            int windowSize = s.isEmpty() ? n : n - s.peek() - 1;
            lenArr.set(top, windowSize);
        }
        
         for (int i = 0; i < n; i++) {
            int windowSize = lenArr.get(i) - 1;  
            res.set(windowSize, Math.max(res.get(windowSize), arr[i]));
        }
        
        for (int i = n - 2; i >= 0; i--){
            res.set(i, Math.max(res.get(i), res.get(i + 1)));
        }
        return res;
    }
}
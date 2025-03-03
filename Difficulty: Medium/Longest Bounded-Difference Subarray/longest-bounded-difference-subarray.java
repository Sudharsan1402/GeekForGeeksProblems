//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends


class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
         Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();
        
        // Pointers to mark the range of current subarray
        int n = arr.length, start = 0, end = 0;
        
        // Pointers to mark the range of maximum subarray
        int resStart = 0, resEnd = 0;
        while (end < n) {
            
            // Pop the elements greater than current element
            // from min Queue
            while (!minQueue.isEmpty() && arr[minQueue.peekLast()] > arr[end])
                minQueue.pollLast();
                
            // Pop the elements smaller than current element
            // from max Queue
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] < arr[end])
                maxQueue.pollLast();
                
            // Push the current index to both the queues
            minQueue.addLast(end);
            maxQueue.addLast(end);
            
            // Check if the subarray has maximum difference less
            // than X
            while (arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > x) {
                       
                // Reduce the length of sliding window by moving
                // the start pointer
                if (start == minQueue.peekFirst())
                    minQueue.pollFirst();
                if (start == maxQueue.peekFirst())
                    maxQueue.pollFirst();
                start += 1;
            }
            
            // Maximize the subarray length
            if (end - start > resEnd - resStart) {
                resStart = start;
                resEnd = end;
            }
            end += 1;
        }

        // Return the longest sub-array
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = resStart; i <= resEnd; i++)
            res.add(arr[i]);
            
        return res;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

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

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
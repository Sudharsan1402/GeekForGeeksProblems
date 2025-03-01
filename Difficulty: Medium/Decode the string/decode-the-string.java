//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends



class Solution {
    static String decodeString(String s) {
        // code here
         Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                st.push(s.charAt(i));
            } 
            else {
                StringBuilder temp = new StringBuilder();
                
                while (!st.isEmpty() && st.peek() != '[') {
                    temp.append(st.pop());
                }
                temp.reverse(); 
                st.pop(); 

                StringBuilder num = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    num.insert(0, st.pop());
                }
                int number = Integer.parseInt(num.toString()); 
                StringBuilder repeat = new StringBuilder();
                for (int j = 0; j < number; j++)
                    repeat.append(temp);
                for (char c : repeat.toString().toCharArray())
                    st.push(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        res.reverse();
        return res.toString();
    }
}
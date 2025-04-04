//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> res = new ArrayList<>();

        if (node == null)
            return res;

        // Add root data if it's not a leaf
        if (!isLeaf(node))
            res.add(node.data);

        // Collect left boundary
        collectBoundaryLeft(node.left, res);

        // Collect leaf nodes
        collectLeaves(node, res);

        // Collect right boundary
        collectBoundaryRight(node.right, res);

        return res;
    }

    static void collectBoundaryRight(Node node, ArrayList<Integer> res) {
        if (node == null || isLeaf(node))
            return;

        if (node.right != null)
            collectBoundaryRight(node.right, res);
        else if (node.left != null)
            collectBoundaryRight(node.left, res);

        // Add node data after recursive call to get bottom-up order
        res.add(node.data);
    }

    static void collectLeaves(Node node, ArrayList<Integer> res) {
        if (node == null)
            return;

        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }

        collectLeaves(node.left, res);
        collectLeaves(node.right, res);
    }

    static void collectBoundaryLeft(Node node, ArrayList<Integer> res) {
        if (node == null || isLeaf(node))
            return;

        // Add node data before recursive call to get top-down order
        res.add(node.data);

        if (node.left != null)
            collectBoundaryLeft(node.left, res);
        else if (node.right != null)
            collectBoundaryLeft(node.right, res);
    }

    static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
}

//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    
     static void dfs(List<Integer>[] adj, int c,
                    boolean[] visited) {
        visited[c] = true;
        for (int neighbor : adj[c]) {
            if (!visited[neighbor]) {
                dfs(adj, neighbor, visited);
            }
        }
    }
    static List<Integer>[] constructAdj(int V,
                                        int[][] edges,
                                        int c, int d) {
        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if ((a == c && b == d) || (a == d && b == c))
                continue;

            adj[a].add(b);
            adj[b].add(a);
        }
        return adj;
    }

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // code here
        List<Integer>[] adj = constructAdj(V, edges, c, d);
        boolean[] visited = new boolean[V];
        dfs(adj, c, visited);
        return !visited[d]; 
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            // V and E on separate lines
            int V = Integer.parseInt(sc.nextLine().trim());
            int E = Integer.parseInt(sc.nextLine().trim());

            // Using a 2D array to store edges.
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                // Use split("\\s+") to handle one or more whitespace characters
                String[] parts = sc.nextLine().trim().split("\\s+");
                edges[i][0] = Integer.parseInt(parts[0]);
                edges[i][1] = Integer.parseInt(parts[1]);
            }

            // c and d on separate lines
            int c = Integer.parseInt(sc.nextLine().trim());
            int d = Integer.parseInt(sc.nextLine().trim());

            Solution obj = new Solution();
            boolean result = obj.isBridge(V, edges, c, d);
            System.out.println(result ? "true" : "false");
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends
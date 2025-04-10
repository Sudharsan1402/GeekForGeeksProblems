//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] edge = new int[n][2];
            for (int i = 0; i < n; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minCost(edge);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class DSU {
    private int[] parent;
    private int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 1);
    }

    // Find function with path compression
    public int find(int i) {
        if (parent[i] == -1)
            return i;
        return parent[i] = find(parent[i]);
    }

    // Union function with union by rank
    public void unite(int x, int y) {
        int s1 = find(x);
        int s2 = find(y);

        if (s1 != s2) {
            if (rank[s1] < rank[s2]) {
                parent[s1] = s2;
            } else if (rank[s1] > rank[s2]) {
                parent[s2] = s1;
            } else {
                parent[s2] = s1;
                rank[s1] += 1;
            }
        }
    }
}

class Graph {
    private List<int[]> edgelist;
    private int V;

    public Graph(int V) {
        this.V = V;
        edgelist = new ArrayList<>();
    }

    // Function to add an edge to the graph
    public void addEdge(int x, int y, int w) {
        edgelist.add(new int[]{ w, x, y });
    }

    // Function to calculate MST using Kruskal's Algorithm
    public int kruskalsMST() {
        // Sort all edges by weight
        edgelist.sort(Comparator.comparingInt(a -> a[0]));

        // Initialize DSU
        DSU s = new DSU(V);

        int ans = 0; // Stores total cost
        int count = 0; // Tracks number of edges added to MST

        for (int[] edge : edgelist) {
            int w = edge[0];
            int x = edge[1];
            int y = edge[2];

            // Include edge if it doesn't form a cycle
            if (s.find(x) != s.find(y)) {
                s.unite(x, y);
                ans += w;
                count++;
            }

            // Stop if MST has V-1 edges
            if (count == V - 1) break;
        }

        return ans;
    }
}


class Solution {
    

    public int minCost(int[][] houses) {
        // code here
        int n = houses.length;
        Graph g = new Graph(n);

        // Create edges between every pair of houses
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(houses[i][0] - houses[j][0]) +
                           Math.abs(houses[i][1] - houses[j][1]);
                g.addEdge(i, j, cost);
            }
        }

        // Return the minimum total cost
        return g.kruskalsMST();
    }
}

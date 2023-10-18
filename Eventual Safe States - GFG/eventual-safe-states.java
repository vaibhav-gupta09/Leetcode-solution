//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj) {
        boolean[]visited = new boolean[v];
        boolean[]pathVisited = new boolean[v];
        boolean[]safeNode = new boolean[v];
        
        for(int i=0; i<v; ++i){
            if(visited[i] == false){
                dfs(adj, i, visited, pathVisited, safeNode);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<v; ++i){
            if(safeNode[i])
                ans.add(i);
        }
        return ans;
    }
    
    public boolean dfs(List<List<Integer>> adj, int curr, boolean[]visited, boolean[]pathVisited, 
    boolean[]safeNode){
        if(visited[curr]){
            if(pathVisited[curr] || safeNode[curr]==false){
                return true;
            }
            return false;
        }  
        
        pathVisited[curr] = true;
        visited[curr] = true;
        
        for(int nbr: adj.get(curr)){
            if(dfs(adj, nbr, visited, pathVisited, safeNode)){
                pathVisited[curr] = false;
                return true;
            }
        }
        pathVisited[curr] = false;
        safeNode[curr] = true;
        return false;
    }
}

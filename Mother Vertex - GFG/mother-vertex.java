//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int v, ArrayList<ArrayList<Integer>>adj){
        Stack<Integer> st = new Stack<>();
        int n = adj.size();
        boolean[]visited = new boolean[n];
        for(int i=0; i<n; ++i){
            if(visited[i]) continue;
            getTopoSort(adj, i, visited, st);
        }
        
        visited = new boolean[n];
        int mv = st.pop();
        // System.out.println(mv);
        int size = dfs(adj, mv, visited);
        if(size == n) return mv;
        return -1;
    }
    
    public void getTopoSort(ArrayList<ArrayList<Integer>>adj, int par, boolean[]visited, Stack<Integer> st){
        if(visited[par]) return;
        
        visited[par] = true;
        for(int child: adj.get(par)){
            getTopoSort(adj, child, visited, st);
        }
        
        st.push(par);
    }
    
    public int dfs(ArrayList<ArrayList<Integer>>adj, int par, boolean[]visited){
        if(visited[par]) return 0;
        
        visited[par] = true;
        int count = 1;
        for(int child: adj.get(par)){
            count += dfs(adj, child, visited);
        }
        
        return count;
    }
}
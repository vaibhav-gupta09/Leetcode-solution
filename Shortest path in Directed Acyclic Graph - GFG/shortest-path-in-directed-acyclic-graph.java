//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    public class pair{
        int idx, wt;
        
        pair(int idx, int wt){
            this.idx = idx;
            this.wt = wt;
        }
    }
    
	public int[] shortestPath(int n,int m, int[][] edges) {
		ArrayList<ArrayList<pair>> adj = new ArrayList<>();
		for(int i=0; i<n; ++i) adj.add(new ArrayList<>());
		
		for(int []edge: edges){
		    adj.get(edge[0]).add(new pair(edge[1], edge[2]));
		}
		
		Stack<Integer> st = new Stack<>();
		boolean[]visited = new boolean[n];
		
		for(int i=0; i<n; ++i){
		    if(visited[i]==false)
		        dfs(adj, i, visited, st);
		}
		
		int[]path = new int[n];
		for(int i=1; i<n; ++i){
		    path[i] = Integer.MAX_VALUE;
		}
		
		while(st.size()>0){
		    int rem = st.pop();
		    if(path[rem] == Integer.MAX_VALUE){
		        path[rem] = -1;
		        continue;
		    }
		    
		    for(pair nbr: adj.get(rem)){
		        int cost = nbr.wt + path[rem];
		        if(cost < path[nbr.idx]) path[nbr.idx] = cost;
		    }
		}
		
		return path;
	}
	
	public void dfs(ArrayList<ArrayList<pair>> adj, int i, boolean[]visited, Stack<Integer>st){
        if(visited[i]) return;
        
        visited[i] = true;
        for(pair nbr: adj.get(i)){
            dfs(adj, nbr.idx, visited, st);
        }
        
        st.push(i);
    }



    
}
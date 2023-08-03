//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    public static class pair{
        int curr;
        int wt;
        
        pair(int curr, int wt){
            this.curr = curr;
            this.wt = wt;
        }
    }
	static int spanningTree(int v, int e, int edges[][]){
	    ArrayList<ArrayList<pair>> adj = new ArrayList<>();
	    PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->(a.wt - b.wt));
	    for(int i=0; i<v; ++i){
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int[]edge : edges){
	        adj.get(edge[0]).add(new pair(edge[1], edge[2]));
	        adj.get(edge[1]).add(new pair(edge[0], edge[2]));
	    }
	    pq.add(new pair(0, 0));
	    boolean[]visited = new boolean[v];
	    int cost = 0;
	    
	    while(pq.size()>0){
	        pair rem = pq.remove();
	        if(visited[rem.curr]) continue;
	        visited[rem.curr] = true;
	        cost += rem.wt;
	        
	        for(pair p: adj.get(rem.curr)){
	            if(visited[p.curr]) continue;
	            pq.add(p);
	        }
	    }
	    
	    return cost;
	}
}
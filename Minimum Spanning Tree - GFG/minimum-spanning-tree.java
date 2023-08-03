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
    public static class DSU{
        int[]parent;
        int[]size;
        
        DSU(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0; i<n; ++i){
                parent[i] = i;
            }
        }
        
        public boolean union(int x, int y){
            int px = findPar(x);
            int py = findPar(y);
            
            if(px == py) return false;
            
            balanceSize(px, py);
            
            return true;
        }
        
        public void balanceSize(int px, int py){
            if(size[px] < size[py]){
                parent[px] = py;
            }else if(size[px] > size[py]){
                parent[py] = px;
            }else{
                parent[px] = py;
                size[py] += size[px]; 
            }
        }
        
        public int findPar(int x){
            if(parent[x] == x) return x;
            return parent[x] = findPar(parent[x]);
        }
    }
    
	static int spanningTree(int v, int e, int edges[][]){
	   Arrays.sort(edges, (a,b)->(a[2] - b[2]));
	   DSU dsu = new DSU(v);
	   int cost = 0;
	   for(int []edge: edges){
	       if(dsu.union(edge[0], edge[1])) cost += edge[2];
	   }
	   
	   return cost;
	}
}
//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static class pair implements Comparable<pair>{
        int par,child,wt;
        pair(int par, int child, int wt){
            this.par = par;
            this.wt = wt;
            this.child = child;
        }
        
        public int compareTo(pair o){
            return this.wt - o.wt;
        }
    }
    
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; ++i){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<m; ++i){
            adj.get(edges[i][0]).add(new pair(edges[i][0], edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new pair(edges[i][1], edges[i][0], edges[i][2]));
        }
        int[]par = new int[n+1];
        boolean[]visited = new boolean[n+1];
        pq.add(new pair(-1, 1, 0));
        
        while(pq.size()>0){
            pair rem = pq.remove();
            if(visited[rem.child]) continue;
            visited[rem.child] = true;
            if(rem.par!=-1) par[rem.child] = rem.par;
            if(rem.child == n){
                break;
            }
            
            for(pair p: adj.get(rem.child)){
                if(visited[p.child]) continue;
                pq.add(new pair(rem.child, p.child, rem.wt + p.wt));
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        if(par[n]==0){
            ans.add(-1);
            return ans;
        }
        int idx = n;
        while(idx != 0){
            ans.add(idx);
            idx = par[idx];
        }
        
        Collections.reverse(ans);
        
        return ans;
        
    }
}
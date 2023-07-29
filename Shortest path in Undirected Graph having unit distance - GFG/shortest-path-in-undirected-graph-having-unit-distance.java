//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       
       for(int i=0; i<n; ++i) adj.add(new ArrayList<>());
       
       for(int[]edge: edges){
           adj.get(edge[0]).add(edge[1]);
           adj.get(edge[1]).add(edge[0]);
       }
       
       int[]path = new int[n];
       Queue<Integer> que = new ArrayDeque<>();
       que.add(src);
       int dist = 1;
       
       while(que.size()>0){
           int len = que.size();
           while(len-->0){
               int rem = que.remove();
               for(int nbr: adj.get(rem)){
                   if(nbr==src || path[nbr]!=0)continue;
                   path[nbr] = dist;
                   que.add(nbr);
               }
           }
           dist++;
       }
       for(int i=0; i<n; ++i){
           if(i!=src && path[i]==0) path[i] = -1;
       }
       return path;
    }
}
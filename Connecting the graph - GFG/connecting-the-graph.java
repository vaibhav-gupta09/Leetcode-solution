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
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
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
            
            if(px == py) return true;
            
            balanceSize(px, py);
            
            return false;
        }
        
        private void balanceSize(int px, int py){
            if(size[px] < size[py]){
                parent[px] = py;
            }else if(size[px] > size[py]){
                parent[py] = px;
            }else{
                parent[px] = py;
                size[py] += size[px]; 
            }
        }
        
        private int findPar(int x){
            if(parent[x] == x) return x;
            return parent[x] = findPar(parent[x]);
        }
    }
    public int Solve(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int x = 0;
        for(int[]edge: edges){
            boolean flag = dsu.union(edge[0], edge[1]);
            x += flag?1:0;
        }
        
        int count = 0;
        for(int i=0; i<n; ++i){
           if(dsu.parent[i] == i) count++;
        }
       
       return x>=count-1?count-1:-1;
    }
}
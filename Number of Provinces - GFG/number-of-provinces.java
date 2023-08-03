//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

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
        
        public void union(int x, int y){
            int px = findPar(x);
            int py = findPar(y);
            
            if(px == py) return;
            
            balanceSize(px, py);
            
            return;
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
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
       DSU dsu = new DSU(v);
       for(int i=0; i<adj.size(); ++i){
           for(int j=0; j<adj.get(i).size(); j++){
               if(adj.get(i).get(j) == 1)
               dsu.union(i, j);
           }
       }
       
       int count = 0;
       for(int i=0; i<v; ++i){
           if(dsu.parent[i] == i) count++;
       }
       
       return count;
    }
};
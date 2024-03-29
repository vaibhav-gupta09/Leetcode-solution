//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
   
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        // boolean[][]visited = new boolean[n][m];
        for(int i=0; i<n; ++i){
            if(grid[i][0]==1)
                dfs(grid, i, 0);
            
            if(grid[i][m-1]==1)
               dfs(grid, i, m-1);
        }
        
        for(int j=m-2; j>=1; j--){
            if(grid[0][j]==1)
              dfs(grid, 0, j);
              
            if(grid[n-1][j]==1)
               dfs(grid, n-1, j);
        }
        
        int ans = 0;
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(grid[i][j]==1)
                ans++;
            }
        }
        return ans;
    }
    
    void dfs(int[][]grid, int i, int j){
        int n = grid.length, m = grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]!=1) return;
        
        grid[i][j] = 2;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
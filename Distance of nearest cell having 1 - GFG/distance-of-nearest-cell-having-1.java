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
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid){
        int n = grid.length, m = grid[0].length;
        Queue<int[]> que = new ArrayDeque<>();
        
        for(int i=0;i<n; ++i){
            for(int j=0; j<m; ++j){
                if(grid[i][j]==1){
                    que.add(new int[]{i, j});
                    grid[i][j] = -1;
                }
            }
        }
        
        int[][]dir = {{0,-1}, {-1,0}, {1,0}, {0,1}};
        int pos = 1;
        while(que.size()>0){
            int len = que.size();
            while(len-->0){
                int[]rem = que.remove();
                for(int k=0; k<4; ++k){
                    int ni = rem[0] + dir[k][0];
                    int nj = rem[1] + dir[k][1];
                    
                    if(ni<0 || nj<0 || ni>=n || nj>=m || grid[ni][nj]!=0) continue;
                    grid[ni][nj] = pos;
                    
                    que.add(new int[]{ni, nj});
                }
            }
            pos++;
        }
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(grid[i][j] == -1)
                    grid[i][j]  = 0;
            }
        }
        
        return grid;
    }
}
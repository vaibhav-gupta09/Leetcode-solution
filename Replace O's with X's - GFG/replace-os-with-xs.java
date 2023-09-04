//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][]){
        Queue<int[]> que = new ArrayDeque<>();
        for(int i=0; i<n; ++i){
            if(a[i][0]=='O'){
                a[i][0] = '1';
                que.add(new int[]{i, 0});
            }
            if(a[i][m-1]=='O'){
                a[i][m-1] = '1';
                que.add(new int[]{i, m-1});
            }
        }
        
        for(int j=0; j<m; ++j){
            if(a[0][j] == 'O'){
                a[0][j] = '1';
                que.add(new int[]{0, j});
            }
            
            if(a[n-1][j] == 'O'){
               a[n-1][j] = '1';
               que.add(new int[]{n-1, j}); 
            }
        }
        
        int[][]dir = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}}; 
        
        while(que.size()>0){
          int[]rem = que.remove();
          for(int k=0; k<4; ++k){
              int ni = rem[0] + dir[k][0];
              int nj = rem[1] + dir[k][1];
              
              if(ni<0 || nj<0 || ni>=n || nj>=m || a[ni][nj]!='O') continue;
              a[ni][nj] = '1';
              que.add(new int[]{ni, nj}); 
          }
        }
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(a[i][j] == '1'){
                    a[i][j] = 'O';
                }else{
                    a[i][j] = 'X';
                }
            }
        }
        
        return a;
    }
}
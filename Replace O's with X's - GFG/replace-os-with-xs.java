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
                que.add(new int[]{i, 0});
                a[i][0] = 'Y';
            }
            if(a[i][m-1]=='O'){ 
                que.add(new int[]{i, m-1});
                a[i][m-1] = 'Y';
            }
        }
        
        for(int j=0; j<m; ++j){
            if(a[0][j]=='O'){ 
                que.add(new int[]{0, j});
                a[0][j] = 'Y';
            }
            if(a[n-1][j]=='O'){ 
                que.add(new int[]{n-1, j});
                a[n-1][j] = 'Y';
            }
        }
        
        int[][]dir = {{0,-1}, {0,1}, {1,0}, {-1,0}};
        while(que.size() > 0){
            int len = que.size();
            
            while(len-->0){
                int[] rem = que.remove();
                
                for(int k=0; k<4; ++k){
                    int ni = rem[0] + dir[k][0];
                    int nj = rem[1] + dir[k][1];
                    
                    if(ni<0 || nj<0 || ni>=n || nj>=m || a[ni][nj]!='O') continue;
                    
                    a[ni][nj] = 'Y';
                    que.add(new int[]{ni, nj});
                }
            }
        }
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(a[i][j]=='O') a[i][j] = 'X';
                if(a[i][j] == 'Y') a[i][j] = 'O';
            }
        }
        return a;
    }
}
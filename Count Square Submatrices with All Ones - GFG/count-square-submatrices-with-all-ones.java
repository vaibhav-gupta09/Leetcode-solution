//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] mat = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.countSquares(N, M, mat);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countSquares(int n, int m, int mat[][]) {
        int[][]dp = new int[n][m];
        int ans = 0;
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(i==0 || j==0){
                    dp[i][j] = mat[i][j];
                    ans += dp[i][j];
                    continue;
                }
                if(mat[i][j]==0) continue;
                dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                ans += dp[i][j];
            }
        }
        
        return ans;
    }
}
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String s){
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for(int k=0; k<n; ++k){
            for(int i=n-k-1; i>=0; --i){
                int j = i+k;
                
                if(i==j){
                    dp[i][j] = 1;
                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                    }
                }
            }
        }
        
        return dp[0][n-1];
    }
}
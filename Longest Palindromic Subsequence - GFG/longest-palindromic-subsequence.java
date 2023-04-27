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
    public int longestPalinSubseq(String s)
    {
        int n = s.length();
        int[][]dp = new int[n][n];
        
        for(int g=0; g<n; ++g){
            for(int i=0; i<n-g; ++i){
                int j = i + g;
                if(g==0) dp[i][j] = 1;
                else{
                    if(s.charAt(i)==s.charAt(j))
                      dp[i][j] = dp[i+1][j-1] + 2;
                    else
                       dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[0][n-1];
    }
}
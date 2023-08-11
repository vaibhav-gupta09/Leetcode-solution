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
        int[][]dp = new int[n][n];

        for(int k=n-1; k>=0; --k){
            int j = n-1;
            for(int i=k; i>=0; --i){

                if(i==j){
                    dp[i][j] = 1;
                }else{
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                
                if(ch1 == ch2) dp[i][j] = dp[i+1][j-1] + 2;
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
                j--;
            }
        }
        
        return dp[0][n-1];
    }
}
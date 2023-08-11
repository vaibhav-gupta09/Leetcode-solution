//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String s){
        int n = s.length();
        int[][]dp = new int[n][n];
        
        for(int k=n-1; k>=0; --k){
            int j = n-1;
            for(int i=k; i>=0; --i){
                if(i==j){
                    dp[i][j] = 1;
                }else{
                    if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1] + 2;
                    else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
                j--;
            }
        }
        
        return n - dp[0][n-1];
    }
}
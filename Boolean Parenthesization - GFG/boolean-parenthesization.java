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
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int mod = 1003;
    static int countWays(int n, String s){
        int[][][]dp = new int[n][n][2];
        for(int [][]d: dp){
            for(int[]a: d){
                Arrays.fill(a, -1);
            }
        }
      return helper(s, 0, n-1, 1, dp);  
    }
    
    static int helper(String s, int si, int ei, int isTrue, int[][][]dp){
        if(si>ei) return 0;
        if(si==ei){
            if(isTrue==1) return s.charAt(si) == 'T'?1:0;
            else return s.charAt(ei) == 'F'?1:0;
        }
        if(dp[si][ei][isTrue]!=-1) return dp[si][ei][isTrue];
        int ways = 0;
        for(int idx=si+1; idx<ei; idx+=2){
            int lft = helper(s, si, idx-1, 1, dp);
            int lff = helper(s, si, idx-1, 0, dp);
            int rtt = helper(s, idx+1, ei, 1, dp);
            int rtf = helper(s, idx+1, ei, 0, dp);
            
            char ch = s.charAt(idx);
            
            if(ch=='&'){
                if(isTrue==1) ways = (ways + lft * rtt)%mod;
                else ways = (ways + lff*rtf + lff*rtt + rtf*lft)%mod;
            }else if(ch=='|'){
                if(isTrue==1) ways = (ways +lft*rtt + lff*rtt + lft*rtf)%mod;
                else  ways = (ways + lff*rtf)%mod;
            }else{
                if(isTrue==1) ways = (ways + lff*rtt + lft*rtf)%mod;
                else ways = (ways + lft*rtt + lff*rtf)%mod;
            }
        }
        
        return dp[si][ei][isTrue] = ways;
    }
}
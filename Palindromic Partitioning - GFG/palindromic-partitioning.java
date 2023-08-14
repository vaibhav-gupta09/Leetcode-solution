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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str){
        int n = str.length();
        int[]dp = new int[n];
        
        for(int i=n-1; i>=0; --i){
            int min = Integer.MAX_VALUE;
        
         for(int idx=i; idx<str.length(); ++idx){
            if(isPallindrome(str, i, idx)){
                min = Math.min(min, (idx+1>=n?0:dp[idx+1]));
            } 
         }
         
         dp[i] = min + 1;
        }
        return dp[0]-1;
    }
    
    // static int helper(String str, int i){
    //     if(i==str.length()) return 0;
        
    //     int min = Integer.MAX_VALUE;
        
    //     for(int idx=i; idx<str.length(); ++idx){
    //         if(isPallindrome(str, i, idx)){
    //             min = Math.min(min, helper(str, idx+1));
    //         } 
    //     }
        
    //     return min + 1;
    // }
    
    static boolean isPallindrome(String str, int lo, int hi){
        while(lo<=hi){
            if(str.charAt(lo) == str.charAt(hi)){
                lo++;
                hi--;
            }else return false;
        }
        
        return true;
    }
}
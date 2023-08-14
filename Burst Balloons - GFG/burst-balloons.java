//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int maxCoins(int n, int[] arr) {
       int[][]dp = new int[n][n];
       
       for(int si=n-1; si>=0; --si){
           for(int ei=0; ei<n; ++ei){
               if(si > ei) continue;
               
               int prev = si<=0?1:arr[si-1];
               int next = ei>=arr.length-1?1:arr[ei+1];
               int max = Integer.MIN_VALUE;
               
               for(int i=si; i<=ei; ++i){
                 int score = prev*arr[i]*next;
                 max = Math.max(max,(i-1>=0?dp[si][i-1]:0) + (i+1<n?dp[i+1][ei]:0) + score);
                }
                
                dp[si][ei] = max;
           }
       }
       
       return dp[0][n-1];
  }
  
//   public static int helper(int[]arr, int si, int ei){
//         if(si > ei) return 0;
        
//         int prev = si<=0?1:arr[si-1];
//         int next = ei>=arr.length-1?1:arr[ei+1];
//         int max = Integer.MIN_VALUE;
//         for(int i=si; i<=ei; ++i){
//             int score = prev*arr[i]*next;
//             max = Math.max(max,helper(arr, si, i-1) + helper(arr, i+1, ei) + score);
//         }
        
//         return max;
//   }
}
     
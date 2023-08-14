//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int k=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.solve(N, k, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int solve(int n, int k, int arr[]){
       int[]dp = new int[n];
       
       for(int i=n-1; i>=0; --i){
           int max = arr[i], sum = 0;
           int ans = Integer.MIN_VALUE;
           for(int idx=i; idx<n && idx<i+k; ++idx){
            max = Math.max(arr[idx], max);
            sum = max*(idx-i+1);
            ans = Math.max(ans, (idx+1<n?dp[idx+1]:0) + sum);
          }
            dp[i] = ans;
       }
       
       return dp[0];
    }
    
    // public int helper(int n, int k, int[]arr, int i){
    //     if(i==n) return 0;
        
    //     int max = arr[i], sum = 0;
    //     int ans = Integer.MIN_VALUE;
    //     for(int idx=i; idx<n && idx<i+k; ++idx){
    //         max = Math.max(arr[idx], max);
    //         sum = max*(idx-i+1);
    //         ans = Math.max(ans, helper(n, k, arr, idx+1) + sum);
    //     }
        
    //     return ans;
    // }
}
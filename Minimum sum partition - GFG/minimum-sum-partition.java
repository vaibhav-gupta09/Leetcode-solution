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
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n){ 
	    int sum = 0;
	    for(int val : arr) sum += val;
	    int[][]dp = new int[n][2*sum+1];
	    for(int[]d: dp) Arrays.fill(d, -1);
	    return helper(arr, n, 0, 0, dp);
	}
	
	public int helper(int[]arr, int n, int sum, int idx, int[][]dp){
	    if(idx==n){
	        return Math.abs(sum);
	    }
	    int tempSum = dp[0].length + sum -1;
	    
	    if(sum<0){
	        if(dp[idx][tempSum]!=-1) return dp[idx][tempSum];
	    }else{
	        if(dp[idx][sum]!=-1) return dp[idx][sum];
	    }
	    int case1 = helper(arr, n, sum-arr[idx], idx+1, dp);
	    int case2 = helper(arr, n, sum+arr[idx], idx+1, dp);
	    
	    if(sum<0) return dp[idx][tempSum]  = Math.min(case1, case2);
	    return dp[idx][sum] = Math.min(case1, case2);
	}
}

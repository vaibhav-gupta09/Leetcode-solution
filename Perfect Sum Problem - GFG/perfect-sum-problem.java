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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    public int mod = 1000000007;
    
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	   int[]next = new int[sum+1];  
	   int[]curr = new int[sum+1];
	   next[sum] = 1;
	   
	   for(int i=n-1; i>=0; --i){
	       for(int j=sum; j>=0; --j){
	           curr[j] =( next[j] + (j+arr[i] <= sum ? next[j+arr[i]]:0))%mod;
	       }
	       
	       next = curr.clone();
	   }
	   
	   return next[0];
	}
	
	public int helper(int[]arr, int n, int sum, int idx, int curr){
	    if(idx==n){
	        if(curr==sum) return 1;
	        else return 0;
	    }
	    
	    int come = helper(arr, n, sum, idx+1, curr + arr[idx]);
	    int notCome = helper(arr, n, sum, idx+1, curr);
	    
	    return (come + notCome)%mod;
	}
}
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

	public int minDifference(int arr[], int n) 
	{ 
	   int sum = 0;
	   for(int val: arr) sum += val;
	   int[]next = new int[sum+1];
	   int[]curr = new int[sum+1];
	   
	   for(int i=0; i<=sum; ++i) next[i] = Math.abs(sum - 2*i);
	   
	   for(int i=n-1; i>=0; --i){
	       for(int j=0; j<=sum; ++j){
	           curr[j] = Math.min(next[j], (j+arr[i]<=sum?next[j+arr[i]]:Integer.MAX_VALUE));
	       }
	       
	       next = curr.clone();
	   }
	   
	   return next[0];
	} 
	
// 	public int helper(int[]arr, int idx, int curr, int sum, int n){
// 	    if(idx==n){
// 	        return Math.abs(sum - 2*curr);
// 	    }
	    
// 	    int come = helper(arr, idx+1, curr+arr[idx], sum, n);
// 	    int notCome = helper(arr, idx+1, curr, sum, n);
	    
// 	    return Math.min(come, notCome);
// 	}
}

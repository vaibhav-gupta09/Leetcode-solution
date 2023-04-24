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
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int arr[], int n, int sum){
	    int []next = new int[sum+1];
	    int []curr = new int[sum+1];
	    Arrays.fill(next, Integer.MAX_VALUE);
	    next[sum] = 0;
	    
	    for(int i=n-1; i>=0; --i){
	        for(int j=sum; j>=0; --j){
	            int come = j+arr[i]>sum?Integer.MAX_VALUE:curr[j + arr[i]];
	            int notcome = next[j];
	            come = come==Integer.MAX_VALUE ?come:come+1;
	            curr[j] = Math.min(come, notcome);
	        }
	        
	        next = curr.clone();
	    }
	    
	    return next[0]==Integer.MAX_VALUE?-1:next[0];
	}
	
// 	public int helper(int[]arr, int n, int sum, int idx, int curr){
// 	    if(idx==n){
// 	        if(curr==sum) return 0;
// 	        else return Integer.MAX_VALUE;
// 	    }
	    
// 	    int come = helper(arr, n, sum, idx, curr+arr[idx]);
// 	    int notcome = helper(arr, n, sum, idx+1, curr);
// 	    come = come==Integer.MAX_VALUE ?come:come+1;
	    
// 	    return Math.min(come, notcome);
// 	}
}
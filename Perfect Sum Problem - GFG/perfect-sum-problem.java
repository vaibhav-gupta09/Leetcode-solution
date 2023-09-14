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

	public int perfectSum(int nums[],int n, int tar) { 
	   int next[] = new int[tar+1];
        int curr[] = new int[tar+1];

        int mod = 1000000007;
        next[0] = 1;

        for(int i=nums.length-1; i>=0; --i){
            for(int j=0; j<=tar; ++j){
                if(j-nums[i]<0){
                    curr[j] = next[j];
                    continue;
                }

                int come = next[j-nums[i]];
                int notCome = next[j];
                curr[j] = (come + notCome)%mod;
            }

            int[] temp = next;
            next = curr;
            curr = temp;
        }

        return next[tar];
    }
}
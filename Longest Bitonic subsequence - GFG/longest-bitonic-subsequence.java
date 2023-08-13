//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] arr){
        int n = arr.length;
        int[]front = new int[n];
        int[]back = new int[n];
        
        Arrays.fill(front, 1);
        Arrays.fill(back, 1);
        
        for(int i=1; i<n; ++i){
            for(int j=i-1; j>=0; --j){
                if(arr[i] > arr[j]) front[i] = Math.max(front[i], front[j] + 1);
            }
        }
        
        for(int i=n-2; i>=0; --i){
            for(int j=i+1; j<n; ++j){
                if(arr[i] > arr[j]) back[i] = Math.max(back[i], back[j] + 1);
            }
        }
        int ans = 1;
        for(int i=0; i<n; ++i) ans = Math.max(ans, front[i] + back[i] - 1);
        return ans;
    }
}
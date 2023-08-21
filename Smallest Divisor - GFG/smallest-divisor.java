//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int smallestDivisor(int[] nums, int k) {
        int lo = 1, hi = nums[0];
        for(int val: nums) hi = Math.max(hi, val);
        int ans = hi;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int score = getScore(nums, mid);
            // System.out.println(score);
            if(score<=k){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
    
    public static int getScore(int[]nums, int div){
        int score = 0;
        for(int val: nums){
            if(val%div==0){
                score += val/div;
            }else{
                score += val/div + 1;
            }
        }
        
        return score;
    }
}
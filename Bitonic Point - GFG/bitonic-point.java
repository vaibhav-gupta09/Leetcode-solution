//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaximum(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int findMaximum(int[] nums, int n) {
        int lo = 0, hi = n-1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int left = mid-1<0?Integer.MIN_VALUE:nums[mid-1];
            int right = mid+1>=nums.length?Integer.MIN_VALUE:nums[mid+1];
            if(nums[mid] > left && nums[mid] > right){
                return nums[mid];
            }
            
            if(nums[mid]<left){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return nums[0];
    }
}
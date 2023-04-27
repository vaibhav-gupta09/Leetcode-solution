//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        int []next = new int[n+2];
        int []curr = new int[n+2];
        
        
        for(int i=n; i>=1; --i){
            for(int j=n; j>=0; --j){
                int val1 = (j + i <= n) ? curr[j+i] + price[i-1] : 0;
                int val2 = next[j];
                
                curr[j] = Math.max(val1, val2);
            }
            
            next = curr.clone();
        }
        return next[0]; 
    }
    
    public int helper(int[]arr, int idx, int len, int n){
        if(idx==n+1) return 0;
        
        int val1 = (len + idx <= n) ? helper(arr, idx, len+idx, n) + arr[idx-1] : 0;
        int val2 = helper(arr, idx+1, len, n);
        
        return Math.max(val1, val2);
    }
}
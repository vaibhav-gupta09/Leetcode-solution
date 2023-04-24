//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays(int[] arr , int n, int target) {
       int sum = 0;
       for(int val: arr) sum += val;
       if(target>sum || target<-sum) return 0;
       int next[] = new int[2*sum+1];
       int curr[] = new int[2*sum+1];
       
       if(target>=0) next[target] = 1;
       else next[sum-target]=1;
       
       for(int idx=n-1; idx>=0; --idx){
           for(int j=sum; j>=-sum; --j){
               int add=0, sub=0;
               if(j+arr[idx]>sum) add = 0;
               else if(j+arr[idx]>=0) add = next[j+arr[idx]];
               else add = next[sum - (j+arr[idx])];
               
               if(j-arr[idx]<-sum) sub=0;
               else if(j-arr[idx]<0) sub = next[sum - (j-arr[idx])];
               else sub = next[j-arr[idx]];

               if(j<0)
               curr[sum - j] = add + sub;
               else
               curr[j] = add + sub;
           }
           
           next = curr.clone();
       }
       
       return next[0];
      } 
    
    // static int helper(int[]arr, int n, int target, int idx, int curr){
    //     if(idx==n){
    //         if(curr==target) return 1;
    //         else return 0;
    //     }
        
    //     int add = helper(arr, n, target, idx+1, curr+arr[idx]);
    //     int sub = helper(arr, n, target, idx+1, curr-arr[idx]);
        
    //     return add + sub;
    // }
};
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            long []prices=new long[N];
            for(int i=0;i<N;i++){
                prices[i]=sc.nextLong();
            }
            Solution obj=new Solution();
            long res=obj.maximumProfit(prices,N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long maximumProfit(long prices[], int n){
        long [][]next = new long[2][2];
        long [][]curr = new long[2][2];
        
        for(int i=n-1; i>=0; --i){
            curr[0][0] = Math.max(next[1][0] - prices[i], next[0][0]);
            curr[0][1] = Math.max(0, next[0][0]);
            curr[1][0] = Math.max(next[0][1] + prices[i], next[1][0]);
            
            // System.out.println(curr[0][0] + " " + curr[0][1] + " " + curr[1][0]);
            next[0] = curr[0].clone();
            next[1] = curr[1].clone();
        }
        
        return next[0][0];
        
        // return helper(prices, 0, 0, 0, n);
    }
     
     // 0->buy 1->sell
     
     public long helper(long[]prices, int idx, int dec, int cd, int n){
         if(idx==n) return 0;
         
         long case1 = 0, case2 = 0;
         
         if(dec==0){
            case1 = cd==1?0:(helper(prices, idx+1, 1, 0, n) - prices[idx]); 
            case2 = helper(prices, idx+1, 0, 0, n); 
         } else{
            case1 = helper(prices, idx+1, 0, 1, n) + prices[idx];
            case2 = helper(prices, idx+1, 1, 0, n);
         }
         
         return Math.max(case1, case2);
     }
}

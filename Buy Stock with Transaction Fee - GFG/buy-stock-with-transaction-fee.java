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
            int fee=sc.nextInt();
            Solution obj=new Solution();
            long res=obj.maximumProfit(prices,N,fee);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long maximumProfit(long prices[], int n, int fee){
       long[]next = new long[2];
       long[]curr = new long[2];
       
       for(int i=n-1; i>=0; i--){
           curr[0] = Math.max(next[1] - prices[i], next[0]);
           curr[1] = Math.max(next[0] + prices[i] - fee, next[1]);
           
           next = curr.clone();
       }
       
       return curr[0];
    }
}
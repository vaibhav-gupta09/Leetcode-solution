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
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{
    public int mod = 1000000007;
    
    public int countPartitions(int n, int d, int arr[]){
        int sum = 0;
        for(int val: arr) sum += val;
        
        int []next = new int[sum+1];
        int[]curr = new int[sum+1];
        
        for(int i=sum; i>=0; --i){
            if( (2*i-sum)==d ) next[i] = 1;
        }
        
        for(int i=n-1; i>=0; --i){
            for(int j=sum; j>=0; --j){
                curr[j] = (next[j] + (j+arr[i] <= sum ? next[j+arr[i]]: 0))%mod;
            }
            
            next = curr.clone();
        }
        return next[0];
    }
}
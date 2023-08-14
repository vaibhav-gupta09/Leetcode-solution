//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int n, int arr[]){
        int [][]dp = new int[n][n];
        
        for(int k=n-1; k>=0; --k){
            int j = n-1;
            for(int i=k; i>=0; --i){
                
                if(i==j || i+1==j) continue;
                
                int c = i+1, r=i+1;
                int min = Integer.MAX_VALUE;
                while(c<j){
                    int val = dp[i][c] + dp[r][j] + arr[i]*arr[c]*arr[j];
        // System.out.println( dp[i][c] + " " + dp[r][j] + " " + arr[i]*arr[c]*arr[j]);
                    min = Math.min(val, min);
                    
                    c++;
                    r++;
                }
                
                dp[i][j] = min;
                j--;
            }
        }
        
        return dp[0][n-1];
    }
}
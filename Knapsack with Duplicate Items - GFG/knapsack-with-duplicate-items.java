//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    static int knapSack(int n, int wt, int val[], int w[]){
        int[]curr = new int[wt+1];
        int[]next = new int[wt+1];
        
        for(int i=n-1; i>=0; --i){
            for(int j=0; j<=wt; ++j){
                int come = (j-w[i]>=0)?(curr[j-w[i]] + val[i]):0;
                int notCome = next[j];
                
                curr[j] = Math.max(come, notCome);
            }
            
            next = curr.clone();
        }
        
        return next[wt];
    }
}
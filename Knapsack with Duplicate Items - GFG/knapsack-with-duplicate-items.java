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
    static int knapSack(int n, int w, int val[], int wt[]){
        int[]next = new int[w+1];
        int[]curr = new int[w+1];
        for(int i=n-1; i>=0; i--){
            for(int j=w-1; j>=0; --j){
                int val1 = (j+wt[i]<=w)?curr[j+wt[i]]+val[i]:0;
                int val2 = next[j];
                
                curr[j] = Math.max(val1, val2);
            }
            
            next = curr.clone();
        }
        return next[0];
    }
    
    static int helper(int n, int idx, int curr, int w, int val[], int[]wt){
        if(n==idx){
            return 0;
        } 
        
        
        int val1 = (curr + wt[idx] <=w) ? helper(n, idx, curr+wt[idx], w, val, wt) + val[idx] : 0;
        int val2 = helper(n, idx+1, curr, w, val, wt);
        return Math.max(val1, val2);
    }
}
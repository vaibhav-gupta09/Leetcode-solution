//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int k, int n, int prices[]) {
      int [][]next = new int[2][k+1];
	  int [][]curr = new int[2][k+1];
	  
	  for(int i=n-1; i>=0; --i){
		  curr = new int[2][k+1];
          for(int j=0; j<k; j++){
              curr[0][j] = Math.max(next[1][j] - prices[i], next[0][j]);
              curr[1][j] = Math.max(next[0][j+1] + prices[i], next[1][j]);
          }
		  next = curr;
	  }

	  return next[0][0]; 
    }
}
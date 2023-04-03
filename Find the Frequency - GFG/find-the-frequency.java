//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 
    
class GFG {
    public static void main(String args[]) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            Solution ob = new Solution();
            int N = sc.nextInt(), A[] = new int[N];
    	    for(int i = 0;i<N;i++){
    	        A[i] = sc.nextInt();
    	    }
    	    
    	    // element whose frequency to be find
    	    int x = sc.nextInt();
    	    out.println(ob.findFrequency(A, x));
        }
        out.flush();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {

  int findFrequency(int A[], int x) {
    // Initialize frequency of x to 0
    int frequency = 0;

    // Iterate through the vector
    for (int i = 0; i < A.length; i++) {
      // If the current element is x, increment the frequency
      if (A[i] == x) {
        frequency++;
      }
    }

    // Return the frequency
    return frequency;
  }
};
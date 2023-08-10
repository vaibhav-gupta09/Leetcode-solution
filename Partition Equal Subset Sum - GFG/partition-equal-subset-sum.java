//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int n, int arr[]){
        int sum = 0;
        for(int val: arr) sum += val;
        if(sum%2==1) return 0;
        
        int[]prev = new int[sum/2 +1];
        int[]curr = new int[sum/2 +1];
        prev[0] = 1;
        
        for(int val: arr){
            for(int i=0; i<=sum/2; ++i){
                if(i<val){
                    curr[i] = prev[i];
                    continue;
                }
                
                if(prev[i-val]==1) curr[i] = 1;
                else curr[i] = prev[i];
            }
            
            prev = curr.clone();
        }
        
        return prev[sum/2];
    }

}
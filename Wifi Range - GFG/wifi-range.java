//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            String S = read.readLine().trim();
            Solution ob = new Solution();
            boolean ans = ob.wifiRange(N, S, X); 
            if(ans)
            System.out.println(1);
            else
            System.out.println(0);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean wifiRange(int n, String s, int x) 
    { 
        int[]dp = new int[n];
        for(int i=0; i<n; ++i){
            char ch = s.charAt(i);
            if(ch=='1'){
                if(i-x<0) dp[0] += 1;
                else dp[i-x] += 1;
    
                if(i+x+1<n) dp[i+x+1] += -1;
            }        
        }
        
        if(dp[0]==0) return false;
        for(int i=1; i<n; ++i){
            dp[i] += dp[i-1];
            if(dp[i]==0) return false;
        }
        
        return true;
    }
} 
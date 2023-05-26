//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    static int mod = (int)(1e9) + 7;
    static int numOfWays(int n, int x){
        int dp[][] = new int[n+2][n+1];
        for(int i=0; i<=n+1; ++i) dp[i][n] = 1;
        
        for(int i=n; i>=1; --i){
            for(int j=n-1; j>=0; --j){
                int pow = (int)power(i, x);
                int come = (j+pow)<=n?dp[i+1][j+pow]:0;
                int notCome = dp[i+1][j];
                dp[i][j] = (come + notCome)%mod;
            }
        }
        return dp[1][0];
    }
    
    static long power(int x, int y){
        if(y==1)return x;
        
        long temp = power(x, y/2);
        if(y%2==1){
            return (temp*temp*x)%mod;
        }else{
            return (temp*temp)%mod;
        }
    }
}
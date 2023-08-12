//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        int n = s.length(), m = t.length();
        int[][]dp = new int[n+1][m+1];
        
        for(int j=0; j<=m; ++j) dp[n][j] = t.length()-j;
        for(int i=0; i<n; ++i) dp[i][m] = s.length()-i;
        
        for(int i=n-1; i>=0; --i){
            for(int j=m-1; j>=0; --j){
                if(s.charAt(i) == t.charAt(j)){
                   dp[i][j] = dp[i+1][j+1]; 
                }else{
                    int replace = dp[i+1][j+1];
                    int insert = dp[i][j+1];
                    int delete = dp[i+1][j];
                    
                    dp[i][j] = Math.min(replace, Math.min(insert, delete)) + 1;
                }
            }
        }
        
        return dp[0][0];
    }
    
    // public int helper(String s, String t, int i, int j){
    //     if(i==s.length()) return t.length - j;
    //     if(j==t.length()) return s.length()-i;
        
    //     if(s.charAt(i) == t.charAt(j)){
    //         return helper(s, t, i+1, j+1);
    //     }else{
    //         int replace = helper(s, t, i+1, j+1);
    //         int insert = helper(s, t, i, j+1);
    //         int delete = helper(s, t, i+1, j);
            
    //         return Math.min(replace, Math.min(insert, delete)) + 1;
    //     }
    // }
}
//{ Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int wildCard(String pat, String str)
    {
        // return helper(pat, str, 0, 0);
        int n = str.length(), m = pat.length();
        int[][]dp = new int[n+1][m+1];
        dp[n][m] = 1;
        int c = m-1;
        while(c>=0 && pat.charAt(c)=='*') {
            dp[n][c] = 1;
            c--;
        }
        
        for(int i=n-1; i>=0; --i){
            for(int j=m-1; j>=0; --j){
                char chs = str.charAt(i);
                char chp = pat.charAt(j);
                if(chp==chs || chp=='?') dp[i][j] = dp[i+1][j+1];
                else{
                  if(chp=='*') 
                     dp[i][j] = Math.max(dp[i+1][j+1], Math.max(dp[i+1][j], dp[i][j+1]));
                  else
                     dp[i][j] = 0;
                }
                
            }
        }
        return dp[0][0];
    }
    
    // int helper(String pat, String str, int i, int j){
    //     if(i==pat.length() && j==str.length()) return 1;
    //     if(j==str.length()){
    //         while(j<pat.length() && pat.charAt(j)=='*')j++;
    //         return j==pat.length()?1:0;
    //     }
    //     if(i == pat.length()) return 0;
       
        
    //     char chp = pat.charAt(i);
    //     char chs = str.charAt(j);
        
    //     if(chp==chs || chp=='?') return helper(pat, str, i+1, j+1);
    //     else{
    //         if(chp=='*') 
    //             return Math.max(helper(pat, str, i+1, j+1), 
    //             Math.max(helper(pat, str, i, j+1), helper(pat, str, i+1, j)));
    //         else
    //             return 0;
    //     }
    // }
}

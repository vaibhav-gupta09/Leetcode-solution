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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix){
        int n = matrix.length, m = matrix[0].length;
        int[][]dir = {{0,-1}, {-1,0}, {1,0}, {0,1}, {1,1}, {1,-1}, {-1,-1}, {-1, 1}};
        int ans = 0;
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                int count = 0;
                if(matrix[i][j] == 0) continue;
                for(int k=0; k<8; ++k){
                    int nr = dir[k][0] + i;
                    int nc = dir[k][1] + j;
                    if(nr<0 || nc<0 || nr>=n || nc>=m || matrix[nr][nc]==1) continue;
                    count++;    
                }
                if(count!=0 && count%2==0) ans++;
            }
        }
        return ans;
    }
}
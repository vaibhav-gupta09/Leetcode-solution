//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Gfg {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            char c[][]=new char[n][m];
            for(int i=0;i<n;i++){
                s=in.readLine().trim().split(" ");
                for(int j=0;j<m;j++){
                    c[i][j]=s[j].charAt(0);
                }
            }
            Solution ob=new Solution();
            int ans[][]=ob.chefAndWells(n, m, c);

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    out.print(ans[i][j]+" ");
                }
                out.println();
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[][] chefAndWells(int n,int m,char c[][])
    {
        int [][]arr = new int[n][m];
        int[][]dir = {{0,1}, {1,0}, {-1, 0}, {0,-1}};
        
        Queue<int[]> que = new ArrayDeque<>();
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(c[i][j]=='W') que.add(new int[]{i, j});
            }
        }
        int count = 1;
        while(que.size()>0){
            int len = que.size();
            while(len-->0){
                int[]rem = que.remove();
                for(int k=0; k<4; ++k){
                    int nr = rem[0] + dir[k][0];
                    int nc = rem[1] + dir[k][1];
                    
    if(nr<0 || nc<0 || nr>=n || nc>=m || c[nr][nc]=='N' || arr[nr][nc]!=0 || c[nr][nc]=='W') continue;
                    
                    arr[nr][nc] = 2*count;
                    // System.out.println(arr[nr][nc]);
                    que.add(new int[]{nr, nc});
                }
            }
            count++;
        }
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(c[i][j]!='H') arr[i][j] = 0;
                else{
                    if(arr[i][j]==0) arr[i][j] = -1;
                }
            }
        }
        
        return arr;
    }
}
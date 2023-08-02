//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int shortestDistance(int n, int m, int arr[][], int x, int y) {
       if(arr[0][0]==0) return -1;
       
       Queue<int[]> que = new ArrayDeque<>();
       que.add(new int[]{0, 0});
       int[][]dir = {{0,1}, {0,-1}, {-1,0}, {1,0}};
       
       int steps = 0;
       while(que.size()>0){
           int len = que.size();
           while(len-->0){
               int[]rem = que.remove();
               if(rem[0]==x && rem[1]==y) return steps;
               
               for(int k=0; k<4; ++k){
                   int ni = dir[k][0] + rem[0];
                   int nj = dir[k][1] + rem[1];
                   
                   if(ni<0 || nj<0 || ni>=n || nj>=m || arr[ni][nj]!=1) continue;
                   arr[ni][nj] = -1;
                   que.add(new int[]{ni, nj});
               }
           }
           steps++;
       }
       
       return -1;
    }
};
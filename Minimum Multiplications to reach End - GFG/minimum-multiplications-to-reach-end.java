//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        boolean[]visited = new boolean[100001];
        visited[start] = true;
        int steps = 0;
        
        while(que.size()>0){
            int len = que.size();
            
            while(len-->0){
                int rem = que.remove();
                
                if(rem == end) return steps;
                
                for(int val: arr){
                    int num = (val*rem)%100000;
                    if(visited[num]) continue;
                    que.add(num);
                    visited[num] = true;
                }
            }
            
            steps++;
        }
        
        return -1;
    }
}

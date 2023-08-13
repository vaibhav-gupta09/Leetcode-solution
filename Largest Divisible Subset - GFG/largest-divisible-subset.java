//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> res = obj.LargestSubset(N, arr);
            int isValidSeq = 1, sz = res.size();
            for (int i = 0; i < sz; i++) {
                for (int j = i + 1; j < sz; j++) {
                    if ((res.get(i) % res.get(j) == 0) ||
                        (res.get(j) % res.get(i) == 0))
                        continue;
                    else {
                        isValidSeq = 0;
                        break;
                    }
                }
            }
            System.out.println(isValidSeq + " " + sz);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> LargestSubset(int n, int[] arr) {
        int[]dp = new int[n];
        int[]par = new int[n];
        int idx = 0, max = 1;
        Arrays.sort(arr);
        Arrays.fill(dp, 1);
        for(int i=0; i<n; ++i) par[i] = i;
        
        for(int i=1; i<n; ++i){
            for(int j=i-1; j>=0; --j){
                if(arr[i]%arr[j]==0){
                    if(dp[j]+1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        par[i] = j;
                    }
                }
            }
            
            if(dp[i] > max){
                idx = i;
                max = dp[i];
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while(idx!=par[idx]){
            ans.add(arr[idx]);
            idx = par[idx];
        }
        ans.add(arr[idx]);
        return ans;
    }
}

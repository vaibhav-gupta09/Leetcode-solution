//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());

            int K;
            K = Integer.parseInt(br.readLine());

            int target;
            target = Integer.parseInt(br.readLine());

            int[] coins = IntArray.input(br, N);

            Solution obj = new Solution();
            boolean res = obj.makeChanges(N, K, target, coins);

            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean makeChanges(int n, int k, int target, int[] coins) {
        boolean[][]next = new boolean[target+1][k+1];
        boolean[][]curr = new boolean[target+1][k+1];
        next[target][k] = true;
        
        for(int i=n-1; i>=0; --i){
            for(int j=target; j>=0; --j){
                for(int p=k; p>=0; --p){
                    boolean come = false;
                    if(j+coins[i]<=target && p+1<=k)
                     come = curr[j+coins[i]][p+1];
                    boolean notCome = next[j][p];
                    curr[j][p] = come || notCome;
                }
                
            }
            
            for(int j=target; j>=0; --j) next[j] = curr[j].clone();
        }
        
        return next[0][0];
    }
    
    // public static boolean helper(int n, int k, int target, int i, int val, int count, int[]coins){
    //     if(val>target || count>k) return false;
    //     if(i==n){
    //         if(count==k && val==target) return true;
    //         return false;
    //     }
        
    //     boolean come = helper(n, k, target, i, val+coins[i], count+1, coins);
    //     boolean notCome = helper(n, k, target, i+1, val, count, coins);
    //     return come || notCome;
    // }
}

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int n, int[] piles, int h) {
        int lo = 1, hi = 0;
        for(int p: piles) hi = Math.max(hi, p);
        int ans = hi;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int hrTaken = getHours(piles, mid);
            if(hrTaken > h){
                lo = mid+1;
            }else{
                ans = mid;
                hi = mid-1;
            }
        }
        
        return ans;
    }
    
    public static int getHours(int[]piles, int speed){
        int count = 0;
        for(int p: piles){
            count += (p%speed==0)?p/speed:(p/speed+1);
        }
        return count;
    }
}
        

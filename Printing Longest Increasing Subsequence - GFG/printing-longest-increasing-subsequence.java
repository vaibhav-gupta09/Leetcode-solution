//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            ArrayList<Integer>ans=obj.longestIncreasingSubsequence(N, arr);
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public ArrayList<Integer> longestIncreasingSubsequence(int size, int arr[]){
        int[]dp = new int[size];
        int[]par = new int[size];
        for(int i=0; i<size; ++i)par[i] = i;
        Arrays.fill(dp, 1);
        int lis = 0, lisIdx = -1;
        
        for(int i=0; i<size; ++i){
            for(int j=i-1; j>=0; --j){
                if(arr[i] > arr[j] && dp[i]<=dp[j]+1){
                    dp[i] = dp[j]+1;
                    par[i] = j;
                }
            }
            if(dp[i] > lis){
                lis = dp[i];
                lisIdx = i;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(lisIdx != par[lisIdx]){
            list.add(arr[lisIdx]);
            lisIdx = par[lisIdx];
        }
        list.add(arr[lisIdx]);
        Collections.reverse(list);
        return list;
    }   
}

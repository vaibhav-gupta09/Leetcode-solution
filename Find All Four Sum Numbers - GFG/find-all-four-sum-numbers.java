//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends




// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<arr.length-3; ++i){
            // while(i<arr.length-3 && arr[i]==arr[i+1])i++;
            if(i!=0 && arr[i]==arr[i-1]) continue;
            ArrayList<ArrayList<Integer>> list = threeSum(arr, k-arr[i], i+1);
            if(list.size()==0) continue;
            for(ArrayList<Integer>ls: list){
                ls.add(0, arr[i]);
                ans.add(ls);
            }
            
        }
        return ans;
    }
    
    public ArrayList<ArrayList<Integer>> threeSum(int[]arr, int k, int st){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=st; i<arr.length-2; ++i){
            // while(i<arr.length-2 && arr[i]==arr[i+1])i++;
            if(i!=st && arr[i]==arr[i-1]) continue;
            ArrayList<ArrayList<Integer>> list = twoSum(arr, k-arr[i], i+1);
            if(list.size()==0) continue;
            for(ArrayList<Integer>ls: list){
                ls.add(0, arr[i]);
                ans.add(ls);
            }
        }
        return ans;
    }
    
     public ArrayList<ArrayList<Integer>> twoSum(int[]arr, int k, int st){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int lo = st, hi = arr.length-1;
        while(lo < hi){
            int sum = arr[lo] + arr[hi];
            if(sum > k) hi--;
            else if(sum < k) lo++;
            else{
                ArrayList<Integer>list = new ArrayList<>();
                list.add(arr[lo]);
                list.add(arr[hi]);
                ans.add(list);
                lo++;
                hi--;
                while(lo<hi && arr[lo]==arr[lo-1]) lo++;
                while(lo<hi && arr[hi]==arr[hi+1]) hi--;
            }
        }
        return ans;
    }
}
//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[]){
       List<Integer> list = new ArrayList<>();
       list.add(a[0]);
       for(int i=1; i<size; ++i){
           bs(list, 0, list.size()-1, a[i]);
       }
       
       return list.size();
    }
    
    static void bs(List<Integer> list, int lo, int hi, int val){
        int idx = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(list.get(mid)==val) return;
            if(list.get(mid)<val) lo = mid+1;
            else{
                idx = mid;
                hi = mid-1;
            }
        }
        
        if(idx==-1) list.add(val);
        else list.set(idx, val);
    }
} 
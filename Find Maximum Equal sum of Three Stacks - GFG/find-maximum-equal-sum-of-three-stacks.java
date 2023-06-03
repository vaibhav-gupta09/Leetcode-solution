//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 3);
            
            
            int[] S1 = IntArray.input(br, a[0]);
            
            
            int[] S2 = IntArray.input(br, a[1]);
            
            
            int[] S3 = IntArray.input(br, a[2]);
            
            Solution obj = new Solution();
            int res = obj.maxEqualSum(a[0],a[1],a[2], S1, S2, S3);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxEqualSum(int n1,int n2,int n3, int[] s1, int[] s2, int[] s3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for(int val: s1) sum1 += val;
        for(int val: s2) sum2 += val;
        for(int val: s3) sum3 += val;
        int idx1 = 0, idx2 = 0, idx3 = 0;
        while(sum1!=sum2 || sum2!=sum3){
            int min = Math.min(sum1, Math.min(sum2, sum3));
            if(sum1 != min && idx1<n1){
              sum1 -= s1[idx1];
              idx1++;    
            }
            if(sum2 != min && idx2<n2){
              sum2 -= s2[idx2];
              idx2++;    
            }
            if(sum3 != min && idx3<n3){
              sum3 -= s3[idx3];
              idx3++;    
            }
        }
        // System.out.println(sum1 + " " + sum2 + " " + sum3);
        return sum1;
    }
}
        

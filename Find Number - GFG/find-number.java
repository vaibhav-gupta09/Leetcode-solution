//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            long n=Long.parseLong(in.readLine());
            Solution ob=new Solution();
            out.println(ob.findNumber(n));
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long findNumber(long n){
      long ans = 0;
      while(n>0){
       if(n%5==1){
          ans = ans*10 + 1;
          n /= 5;
      }else if(n%5==2){
          ans = ans*10 + 3;
          n /= 5;
      }else if(n%5==3){
          ans = ans*10 + 5;
          n /= 5;
      }else if(n%5==4){
          ans = ans*10 + 7;
          n /= 5;
      }else{
          ans = ans*10 + 9;
          n /= 5;
          n--;
       }
      }
       long res = 0;
       while(ans > 0){
           res = ans%10 + res*10;
           ans = ans/10;
       }
       
       return res;
    } 
}
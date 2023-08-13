//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    static FastReader sc=new FastReader(System.in);
    public static void main(String args[]) throws IOException{
       
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            String []arr=new String[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.next();
            }
            Solution obj=new Solution();
            int res=obj.longestChain(N, arr);
            System.out.println(res);
        }
    }
   static class FastReader{
 
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;
 
        FastReader(InputStream is) {
            in = is;
        }
 
        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }
 
        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan());
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }
 
        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
 
        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
   
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int longestChain(int n, String words[]){
        int[]dp = new int[n];
        
        Arrays.fill(dp, 1);
        Arrays.sort(words, (a,b)->(a.length() - b.length()));
        int ans = 1;
        
        for(int i=1; i<n; ++i){
            for(int j=i-1; j>=0; --j){
                if(words[i].length() - words[j].length() != 1) continue;
                
                int count = 0;
                int ii = 0, jj=0;
                while(jj<words[j].length()){
                    if(words[i].charAt(ii) == words[j].charAt(jj)){
                        ii++;
                        jj++;
                    }else{
                        count++;
                        ii++;
                    }
                    if(count>1) break;
                }
                if(count>1) continue;
                if(dp[j]+1>dp[i])  dp[i] = dp[j] + 1;
            }
            
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}
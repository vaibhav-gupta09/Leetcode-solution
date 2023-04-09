//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int A;
            A = Integer.parseInt(br.readLine());
            
            
            int B;
            B = Integer.parseInt(br.readLine());
            
            
            int C;
            C = Integer.parseInt(br.readLine());
            
            
            int D;
            D = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.bestNumbers(N, A, B, C, D);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
public static int mod = (int)1e9 + 7;
    public static int bestNumbers(int n, int a, int b, int c, int d) {
       long fact[] = new long[n+1];
       fact[0] = 1;
       
       for(int i=1; i<=n; ++i){
           fact[i] = (i*fact[i-1])%mod;
       }
       long ans = 0;
       
       int sum = n*a;
       for(int i=0; i<=n; ++i){
           int temp = sum;
           boolean flag = true;
           while(temp>0){
               int digit = temp%10;
               if(digit!=c && digit!=d){
                   flag = false;
                   break;
               }
               temp = temp/10;
           }
           
           if(flag){
               long den = (fact[i]*fact[n-i])%mod;
               ans = (ans + (fact[n]*modular(den, mod-2))%mod)%mod;
           }
           sum = (n-i-1)*a + (i+1)*b;
       }
       
       return (int)ans;
    }
    
    public static long modular(long x, int y){
        if(y==0) return 1;
        
        if(y%2==1){
            return (x*modular(x, y-1))%mod;
        }else{
            long val = modular(x, y/2);
            return (val*val)%mod;
        }
    }
}
        

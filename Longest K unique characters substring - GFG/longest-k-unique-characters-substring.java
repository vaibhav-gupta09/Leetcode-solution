//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int lo = 0, hi = 0, len = -1, uq = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(hi < s.length()){
            char chHi = s.charAt(hi);
            map.put(chHi, map.getOrDefault(chHi, 0) + 1);
            if(map.size()<k) hi++;
            else if(map.size()==k){
                len = Math.max(len, hi - lo + 1);
                hi++;
            }else{
                while(map.size()!=k){
                    char chLo = s.charAt(lo);
                    map.put(chLo, map.get(chLo) - 1);
                    if(map.get(chLo) == 0) map.remove(chLo);
                    lo++;
                }
                hi++;
            }
        }
        
        return len;
    }
}
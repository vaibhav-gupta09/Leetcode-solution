//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A){
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        ArrayList<Character> list = new ArrayList<>();
        
        for(char ch: A.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
                list.add(ch);
            }else{
                for(int i=0; i<list.size(); ++i){
                    if(list.get(i)==ch)
                     list.remove(i);
                }
            }
            
            if(list.size()==0) sb.append("#");
            else sb.append(list.get(0));
        }
        
        return sb.toString();
    }
}
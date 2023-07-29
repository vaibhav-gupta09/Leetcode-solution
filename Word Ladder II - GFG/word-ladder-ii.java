//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String start, String target, String[] wordList){
       HashMap<String, List<String>> map = new HashMap<>();
        for(String word: wordList){
            buildGraph(word, wordList, map);
        }
        
        if(!map.containsKey(start)){
            buildGraph(start, wordList, map);
        }
        
        HashSet<String> prev = new HashSet<>();
        Queue<ArrayList<String>> que = new ArrayDeque<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(start);
        prev.add(start);
        que.add(ls);
        boolean isFound = false;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        while(que.size()>0){
            int len = que.size();
            HashSet<String> curr = new HashSet<>();
            while(len-->0){
                ArrayList<String> rem = que.remove();
                if( rem.get(rem.size()-1).equals(target) ){
                    isFound = true;
                    ans.add(rem);
                    continue;
                }
                for(String nbr: map.get(rem.get(rem.size()-1))){
                    if(prev.contains(nbr)) continue;
                    
                    ArrayList<String> x = new ArrayList<>();
                    for(String s: rem){
                        x.add(s);
                    }
                    
                    curr.add(nbr);
                    x.add(nbr);
                    que.add(x);
                    // System.out.println(x);
                }
                // System.out.println(set);
                
            }
            
            for(String s: curr){
                    prev.add(s);
                }
            
            if(isFound) break;
        }
        
        return ans;
    }
    
    public void buildGraph(String curr, String[] wordList, HashMap<String, List<String>> map){
        List<String> list = new ArrayList<>();
        
        for(String word: wordList){
            int diff = 0;
            for(int i=0; i<word.length(); ++i){
                if(word.charAt(i)  != curr.charAt(i)) diff++;
                
                if(diff>1) break;
            }
            
            if(diff==1) list.add(word);
        }
        
        map.put(curr, list);
    }
}
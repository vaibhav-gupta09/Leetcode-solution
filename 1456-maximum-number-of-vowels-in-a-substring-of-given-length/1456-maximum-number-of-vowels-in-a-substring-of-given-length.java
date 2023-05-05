class Solution {
    public int maxVowels(String s, int k) {
        int vow = 0, i=0, j=0, ans=0;
HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for( j=0; j<k; ++j){
            char ch = s.charAt(j);
            if(set.contains(ch)) vow++;
        }
        j--;
        // System.out.println(vow + s.substring(i, j));
        while(j<s.length()-1){
            ans = Math.max(ans, vow);
            if(set.contains(s.charAt(i))) vow--;
            i++;
            j++;
            if(set.contains(s.charAt(j))) vow++;
            // System.out.println(vow + s.substring(i, j));
        }
        
        ans = Math.max(ans, vow);
        
        return ans;
    }
}
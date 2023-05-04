class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> que = new ArrayDeque<>();
        // int r = 0, d = 0;
        for(char ch: senate.toCharArray()){
            que.add(ch);
        }
        
        while(que.size() > 0){
            char ch = que.remove();
            if(ch=='R'){
                que.add('R');
                if(que.contains('D')) que.remove('D');
                else return "Radiant";
            }else{
                que.add('D'); 
                if(que.contains('R')) que.remove('R');
                else return "Dire";
            }
        }
        
        return "empty";
    }
    
  
}
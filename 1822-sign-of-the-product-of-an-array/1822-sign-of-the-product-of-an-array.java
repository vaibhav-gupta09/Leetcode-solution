class Solution {
    public int arraySign(int[] nums) {
        int neg=0;
        for(int val: nums){ 
          if(val==0) return 0;
            if(val<0) neg++;
         }
        
        return neg%2==0?1:-1;
    }
}
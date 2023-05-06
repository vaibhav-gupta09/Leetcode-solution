class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = (int)(1e9 + 7);
        Arrays.sort(nums);
        int i = 0, n = nums.length-1, ans=0;
        while(i<=n){
            int val = nums[i];
            int lo = i, hi = n;
            while(lo <= hi){
                int mid = lo + (hi - lo)/2;
                if(nums[mid] + val <= target){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
            if(hi<i){
                
            }
            else if(i==hi) ans = (ans+1)%mod;
            else{
                ans = (ans + pow(hi-i, mod))%mod;
            }
            i++;
        }
        
        return ans;
    }
    
    public int pow(int x, int mod){
        if(x==1) return 2;
        
        int val = pow(x/2, mod);
        long res = ((long)val*(long)val)%mod;
        if(x%2!=0){
          res = (res*2)%mod;            
        }
        return (int)res;
    }

}
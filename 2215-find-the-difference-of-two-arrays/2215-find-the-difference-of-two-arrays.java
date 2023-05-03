class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int val: nums1) set1.add(val);
        for(int val: nums2) set2.add(val);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        for(int val: nums1){
            if(!set2.contains(val)){ list.get(0).add(val);
             set2.add(val);}
        }
        for(int val: nums2){
            if(!set1.contains(val)) {list.get(1).add(val);
             set1.add(val);}
        }
        
        return list;
    }
}
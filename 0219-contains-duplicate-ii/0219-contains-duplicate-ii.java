class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k==0) return false;
        HashSet<Integer> set = new HashSet<Integer>();        
        for (int i=0;i<Math.min(k,nums.length);i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        for (int i=0;i<nums.length-k;i++) {
            if (!set.add(nums[i+k])) return true;
            set.remove(nums[i]);
        }
        return false;
    }
}
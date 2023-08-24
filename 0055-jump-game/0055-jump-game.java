class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length==1) {
            return true;
        }
        
        int possible = nums[0];
        for (int i=0;i<nums.length-1;i++) {
            if (possible >= i) {
                possible = Math.max(nums[i]+i, possible);
                if (possible >= nums.length-1) {
                    return true;
                }
            }
        }
        return false;
    }
}
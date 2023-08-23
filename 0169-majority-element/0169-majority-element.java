class Solution {
    public int majorityElement(int[] nums) {
        int pos = 0;
        Arrays.sort(nums);
        
        for (int i=1;i<nums.length;i++) {
            if (nums[i]!=nums[i-1]) {
                // 서로 다른 숫자 경계지점
                if ((i-pos)>=nums.length/2+1) {
                    return nums[i-1];
                }
                pos = i-1;
            }
        }
        return nums[nums.length-1];
    }
}
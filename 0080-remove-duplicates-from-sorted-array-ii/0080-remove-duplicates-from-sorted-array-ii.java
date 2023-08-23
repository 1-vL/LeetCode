class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int pre = -10001;
        for (int i=1;i<nums.length;i++) {
            if (pre == nums[i]) {
                nums[i] = 10001;
            } else {
                k++;
            }
            if (nums[i] != 10001 && nums[i] == nums[i-1]) {
                pre = nums[i];
            }
        }
        Arrays.sort(nums);
        return k;
    }
}
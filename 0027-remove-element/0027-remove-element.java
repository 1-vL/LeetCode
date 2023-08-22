class Solution {
    public int removeElement(int[] nums, int val) {
        int val_index = -1;
        int k = 0;
        boolean start = false;
        for (int i=0; i<nums.length; i++) {
            if (val == nums[i]) {
                if (!start) {
                    val_index = i;
                    start = true;                    
                }
            } else {
                k++;
            }
            if (start && val != nums[i]) {
                nums[val_index++] = nums[i];
            }
        }
        return k;
    }
}
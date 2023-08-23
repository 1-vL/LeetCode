class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        k = k % nums.length;
        
        int[] temp = new int[k];
        System.arraycopy(nums,nums.length-k,temp,0,temp.length);
        System.arraycopy(nums,0,nums,temp.length,nums.length-k);
        System.arraycopy(temp,0,nums,0,temp.length);
    }
}
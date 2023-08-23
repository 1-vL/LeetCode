class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i=0;i<nums.length;i++) {
            int value = map.getOrDefault(nums[i],0);
            if (majority <= value) {
                return nums[i];
            }
            map.put(nums[i],value+1);
        }
        return -1;
    }
}
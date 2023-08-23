class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i=0;i<nums.length;i++) {
            if (majority <= map.getOrDefault(nums[i],0)) {
                return nums[i];
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return -1;
    }
}
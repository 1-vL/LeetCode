class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;map.put(nums[i],i++)) {
            // num2의 인덱스값 (존재한다면 해당 인덱스, 존재하지 않는다면 -1 리턴)
            if (map.containsKey(target-nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
        }
        // 정답 조합이 존재하지 않는 경우. (문제에서는 정답이 반드시 존재한다.)
        return new int[] {-1, -1};
    }
}
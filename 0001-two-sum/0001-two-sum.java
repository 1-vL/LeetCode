class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;i++) {
            int num2 = target-nums[i]; // 현재 숫자 nums[i]와 합하여 target이 되는 숫자
            int num2_idx = map.getOrDefault(num2, -1);
            // num2의 인덱스값 (존재한다면 해당 인덱스, 존재하지 않는다면 -1 리턴)
            map.put(nums[i],i);
            if (num2_idx == -1) continue; // num2 없으면 continue;
            if (nums[i]!=num2 || i!=num2_idx) { // 요소를 중복사용하지 않았다면 정답
                return new int[] {i, num2_idx}; // 순서는 상관 없으므로 정답이 나오는 순간 즉시 리턴
            }            
        }
        // 정답 조합이 존재하지 않는 경우. (문제에서는 정답이 반드시 존재한다.)
        return new int[] {-1, -1};
    }
}
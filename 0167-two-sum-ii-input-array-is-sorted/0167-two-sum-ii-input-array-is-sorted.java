class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int min_idx = 0;
        int max_idx = numbers.length-1;
        
        // 반드시 정답이 1개 존재한다고 조건을 제시해 줬기 때문에 성능을 위해 그냥 true로 설정
        while (true) {
            int min = numbers[min_idx];
            int max = numbers[max_idx];
            if (min + max == target && (min_idx != max_idx)) {
                return new int[] {min_idx+1, max_idx+1};
            } else if (min + max < target) {
                min_idx++;
            } else if (min + max > target) {
                max_idx--;
            }
        }
    }
}
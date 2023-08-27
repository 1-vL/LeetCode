class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int min_idx = 0;
        int max_idx = numbers.length-1;
        
        // 반드시 정답이 1개 존재한다고 조건을 제시해 줬기 때문에 성능을 위해 그냥 true로 설정
        while (true) {
            if (numbers[min_idx] + numbers[max_idx] == target) {
                return new int[] {min_idx+1,max_idx+1};
            } else if (numbers[min_idx] + numbers[max_idx] < target) {
                min_idx++;
            } else if (numbers[min_idx] + numbers[max_idx] > target) {
                max_idx--;
            }
        }
    }
}
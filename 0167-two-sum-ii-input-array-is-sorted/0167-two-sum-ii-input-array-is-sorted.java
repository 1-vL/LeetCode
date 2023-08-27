class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int min_idx = 0;
        int max_idx = numbers.length-1;
        
        for (int i=0;min_idx < max_idx;i++) {
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
        return new int[] {-1,-1};
    }
}
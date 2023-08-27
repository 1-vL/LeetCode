class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int min_idx = 0;
        int max_idx = numbers.length-1;
        
        // 반드시 정답이 1개 존재한다고 조건을 제시해 줬기 때문에 그냥 true로 설정할 수도 있겠지만 일단 배열 범위를 벗어나면 종료되도록 설정
        while (0 <= min_idx && min_idx < numbers.length && 0 <= max_idx && max_idx < numbers.length) {
            if (numbers[min_idx] + numbers[max_idx] == target) {
                return new int[] {min_idx+1,max_idx+1};
            } else if (numbers[min_idx] + numbers[max_idx] < target) {
                min_idx++;
            } else if (numbers[min_idx] + numbers[max_idx] > target) {
                max_idx--;
            }
        }
        // 위에서 정답을 리턴할 예정이므로 정답이 없는 테스트 케이스가 존재한다면 이 값을 리턴했을 것이다.
        return new int[] {-1,-1};
    }
}
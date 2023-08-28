class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int cnt = Integer.MAX_VALUE;
        
        // 배열 길이가 1인 경우 및 첫번째 요소가 조건을 만족시키는 경우를 빠르게 체크하기 위해서 단 하나 있는 요소가 타겟보다 크다면 즉시 1 리턴
        if (target <= nums[0]) {
            return 1;
        }
            
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];       
            while (target <= sum) {
                cnt = Math.min(cnt, -start + end + 1);
                sum -= nums[start++];
            } 
        }
        if (cnt == Integer.MAX_VALUE) {
            cnt = 0;
        }
        return cnt;
    }
}
class Solution {
    public int findMin(int[] nums) {
        int lo=0, hi=nums.length-1;
        // 한바퀴 돌아서 원래대로 전체 배열이 오름차순인 경우 즉시 0번째 요소 리턴
        if (nums[lo]<=nums[hi]) { return nums[lo]; }

        while (lo < hi) {
            int m = (hi+lo)/2;
            // 현재 구간이 오름차순인 경우
            if (nums[lo]<=nums[m] && nums[m]<=nums[hi]) {
                return nums[lo];
            } else { // 오름차순이 아니라면
                // 왼쪽부터 중간까지는 오름차순이었던 경우
                // -> 우측 어딘가에서 최소값 시작
                if (nums[lo]<=nums[m]) {
                    lo=m+1;
                } else {
                    hi=m;
                }
            }
        }
        return nums[lo];
    }
}
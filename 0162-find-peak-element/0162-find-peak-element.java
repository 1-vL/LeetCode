class Solution {
    public int findPeakElement(int[] nums) {
        // 1개짜리 배열이면 즉시 0리턴
        if (nums.length == 1) { return 0; }
        // 최대값 찾기
        int max = Integer.MIN_VALUE;
        int pos = -1;
        int half = nums.length/2;
        // 배열 요소 수의 절반만큼의 횟수 반복
        for (int i=0;i<half+1;i++) {            
            // 1번 반복 시 2개 요소 확인
            if (2*i<nums.length && max<nums[2*i]) {
                max=nums[2*i];
                pos=2*i;
                }
            if (2*i+1<nums.length && max<nums[2*i+1]) {
                max=nums[2*i+1];
                pos=2*i+1;
                }
        }
        return pos;
    }
}
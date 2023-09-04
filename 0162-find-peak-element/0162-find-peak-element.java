class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length-1, mid = 0;
        // 1개짜리 배열이면 즉시 리턴
        if (nums.length == 1) { return 0; }

        // 이진 탐색 시 start, end, mid 위치의 세 값 중 가장 큰 값을 가진 쪽으로 이동시키기
        while (start < end) {
            mid = (start + end) /2; // 중간 위치
            if (nums[mid]<nums[mid+1]) { // 중간이 자기 옆 칸보다 작다면 -> 피크 가능성 없음
                start = mid+1; // 범위 시작을 중간 옆칸으로
            } else { // 중간이 자기 옆칸 이상이라면
                end = mid; // 끝을 중간 자리로
            }
        } 
        // 탈출 시점에서 start >= end
        return start;
    }
}
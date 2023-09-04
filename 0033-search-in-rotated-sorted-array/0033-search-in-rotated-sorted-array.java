class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while (start < end) {
            int mid = (start+end) / 2;
            // 중간값이 타겟이면 즉시 리턴
            if (nums[mid] == target) { return mid; }
             // 오름차순
            if (nums[start]<=nums[mid]) {
                // 타겟이 시작위치 이상이고, 중간값보다 작은 경우
                // -> 타겟이 왼쪽 구간에 있을 수 있는 경우
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid-1; // 왼쪽구간 탐색
                } else {
                    start = mid+1;
                }
            // 회전된 배열
            } else {
                // 타겟이 우측 값과 중간 값보다 작은 경우
                // -> 타겟이 오른쪽 구간에 있을 수 있는 경우
                if (target <= nums[end] && nums[mid] < target) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }

        // While 문 탈출 이후라면 범위는 1개
        // 마지막 요소가 타겟이면 리턴
        if (nums[start] == target) {
            return start;
        } else {
            // -1 리턴
            return -1;
        }
    }
}
class Solution {
    public void rotate(int[] nums, int k) {
        // 요소 하나짜리 배열이면 이동의 의미 없음
        if (nums.length == 1) {
            return;
        }
        // 이동 수가 배열 길이보다 크면 나머지만큼만 이동
        k = k % nums.length;
        
        int[] temp = new int[k];
        System.arraycopy(nums,nums.length-k,temp,0,temp.length);
        System.arraycopy(nums,0,nums,temp.length,nums.length-k);
        System.arraycopy(temp,0,nums,0,temp.length);
    }
}
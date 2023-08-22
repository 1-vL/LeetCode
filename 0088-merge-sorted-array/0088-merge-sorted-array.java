class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
        // 거의 동일하지만 더 깔끔하고 좁은 범위의 for 문
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        int[] tempnums = Arrays.stream(nums).distinct().toArray();
        int k = tempnums.length;
        System.arraycopy(tempnums, 0, nums, 0, k);
        return k;
    }
}
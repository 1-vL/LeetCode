class Solution {
    public int removeElement(int[] nums, int val) {
        int[] tempnums = Arrays.stream(nums).filter(i -> i != val).toArray();
        int k = tempnums.length;
        System.arraycopy(tempnums, 0, nums, 0, k);
        return k;
    }
}
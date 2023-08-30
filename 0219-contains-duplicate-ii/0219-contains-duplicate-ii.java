class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 최대 K 만큼 떨어진 범위 안에 존재하는 서로 다른
        // 두 요소가 중복인 경우가 존재하는지 체크하고 리턴

        // 슬라이딩 윈도우 + HashSet으로 해결 가능할듯
        if (k==0) return false;
        HashSet<Integer> set = new HashSet<Integer>();        
        for (int i=0;i<Math.min(k,nums.length);i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        for (int i=0;i<nums.length-k;i++) {
            if (set.contains(nums[i+k])) return true;
            set.remove(nums[i]);
            set.add(nums[i+k]);
        }
        return false;
    }
}
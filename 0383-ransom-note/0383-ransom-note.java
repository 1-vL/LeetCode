class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] rn = ransomNote.toCharArray();
        char[] mg = magazine.toCharArray();
        for (int i=0;i<mg.length;i++) {
            map.put(mg[i], map.getOrDefault(mg[i],-1)+1);
        }
        for (int i=0;i<rn.length;i++) {
            if (!map.containsKey(rn[i])) return false;
            int cnt = map.put(rn[i], map.getOrDefault(rn[i],0)-1);
            if (cnt < 0) return false;
        }
        return true;
    }
}
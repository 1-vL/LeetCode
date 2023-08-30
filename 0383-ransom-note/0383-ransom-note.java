class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alpha = new int[26];
        char[] mg = magazine.toCharArray();
        char[] rn = ransomNote.toCharArray();
        
        // magazine의 알파벳 집계
        for (int i=0;i<mg.length;i++) {
            alpha[mg[i] - 'a']++;
        }

        // ransomNote 만드는데 사용한 경우 제거
        for (int i=0;i<rn.length;i++) {
            if (--alpha[rn[i] - 'a'] < 0) return false; // 사용한 후 음수값이 되면 즉시 false 리턴
        }
        return true;
    }
}
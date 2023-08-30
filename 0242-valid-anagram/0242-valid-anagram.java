class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alpha = new int[26];
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        
        // s의 알파벳 집계
        for (int i=0;i<sa.length;i++) {
            alpha[sa[i] - 'a']++;
        }

        // t 만드는데 사용한 경우 제거
        for (int i=0;i<ta.length;i++) {
            if (--alpha[ta[i] - 'a'] < 0) return false;
            // 사용한 후 음수값이 되면 즉시 false 리턴
        }
        // 사용하고 남은 알파벳이 있어도 false
        for (int i=0;i<26;i++) {
            if (alpha[i]!=0) return false;
        }
        return true;
        
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alpha = new int[26];
        
        // s의 알파벳 집계
        for (int i=0;i<s.length();i++) {
            alpha[s.charAt(i) - 'a']++;
        }

        // t 만드는데 사용한 경우 제거
        for (int i=0;i<t.length();i++) {
            if (--alpha[t.charAt(i) - 'a'] < 0) return false;
            // 사용한 후 음수값이 되면 즉시 false 리턴
        }
        // 사용하고 남은 알파벳이 있어도 false
        for (int i : alpha) if (i != 0) return false;
        return true;
        
    }
}
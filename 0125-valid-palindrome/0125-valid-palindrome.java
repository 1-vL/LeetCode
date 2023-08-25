class Solution {
    public boolean isPalindrome(String s) {
        // 문자만 남기기
        s = trim(s);
        
        // 빈 문자열인 경우 true
        if (s.length() == 0) {
            return true;
        }
        
        System.out.println(s);
        
        // 투포인터로 비교후 다른 경우 즉시 false 리턴
        for (int i=0;i<s.length()/2;i++) {            
            System.out.println(s.charAt(i) + " " + s.charAt(s.length()-i-1));
            if (s.charAt(i) != s.charAt(s.length()-1-i)) {
               return false; 
            }
        }
        // 투포인터 통과시 회문
        return true;
    }
    
    public String trim(String s) {
        s=s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++) {            
            char c = s.charAt(i);
            // 숫자 또는 알파벳 소문자만
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
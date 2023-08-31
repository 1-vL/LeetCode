import java.util.StringTokenizer;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        // 패턴과 문장의 공백이 아닌 단어들이 일대일로 매칭(전단사 함수) 되어야 한다.
        // 문장 s는 영문 소문자와 공백 ' '만으로 이루어져 있다.
        // 문장 s는 공백으로 시작하거나 끝나지 않는다.(trim 할 필요 없음)
        // 문장 s의 단어들은 모두 공백 1칸으로 구분지어진다.

        // 패턴의 알파벳 1개당 1개의 단어를 할당해 그 위치에 맞는 단어가 나오는지 체크
        // 알파벳과 단어가 서로 1:1 연관이어야 한다

        StringTokenizer st = new StringTokenizer(s, " ");
        HashMap<String, Character> map = new HashMap<String, Character>();
        if (st.countTokens() != pattern.length()) return false; // 갯수가 다르면 즉시 false

        String[] words = new String[pattern.length()]; // 입력받은 단어들
        String[] alphaWord = new String[26];
        
        for (int i=0;i<words.length;i++) {
            words[i] = st.nextToken();
            if (alphaWord[pattern.charAt(i)-'a'] == null) {                
                alphaWord[pattern.charAt(i)-'a'] = words[i];
            }
            if (words[i].equals(alphaWord[pattern.charAt(i)-'a']) && map.getOrDefault(words[i], pattern.charAt(i)) == pattern.charAt(i)) {
                // 알파벳 1글자가 하나의 단어만을 가리키는지 체크
                // 한 단어가 알파벳 한 글자만을 가리키는지 체크해야함
                alphaWord[pattern.charAt(i)-'a'] = words[i];
                map.put(words[i],pattern.charAt(i));
            } else {
                return false;
            }            
        }
        return true;
    }
}
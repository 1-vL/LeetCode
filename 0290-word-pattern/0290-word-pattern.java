class Solution {
public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (words.length != pattern.length())
        return false;
    Map index = new HashMap();
    for (Integer i=0; i<words.length; ++i) { // int 가 아니라 Integer로 선언해서 오토박싱 되서 Map에 넣는 값과 동일하므로 !=로 비교 가능
        // Map의 타입을 지정하지 않았으므로, String과 char 모두 키가 될 수 있다.
        // <키, 인덱스> 형식으로 값을 넣고, 한 값은 이미 HashMap에 존재하지만, 다른 값은 존재하지 않거나, 서로 다른 인덱스를 가리키는 경우 false 리턴
        // 이미 같은 값이 둘 다 존재하면 둘 다 덮어씌워지고 끝난다.
        if (index.put(pattern.charAt(i), i) != index.put(words[i], i)) return false;
    }
    return true;
}
}
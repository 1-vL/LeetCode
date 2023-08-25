
class Solution {
    public boolean isPalindrome(String s) {
        // char 배열 가져오기
        char[] array = s.toCharArray();
        
        // 앞 포인터 i, 뒤 포인터 j
        int i = 0;
        int j = s.length()-1;
        
        // char 배열 정리
        while (i <=j) {
            if (isUpper(array[i])) {
                array[i] = toLowerCase(array[i]);
            }
            if (isUpper(array[j])) {
                array[j] = toLowerCase(array[j]);
            }
            i++;
            j--;
        }
        
        i = 0;
        j = s.length()-1;
        // 두 포인터가 만나면 탈출
        
        while (i < j) {
            while (i<array.length&&!isAlphaNumeric(array[i])) {
                i++;
            }
            while (i<array.length&&!isAlphaNumeric(array[j])) {
                j--;
            }
            if(j<i){
                return true;
            }
            if (array[i] != array[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public boolean isAlphaNumeric(char c) {
        // 숫자 또는 알파벳 소문자만
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }
    
    public char toLowerCase(char c) {
        return (char) (c+32);
    }
    public boolean isUpper(char c) {        
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }
}
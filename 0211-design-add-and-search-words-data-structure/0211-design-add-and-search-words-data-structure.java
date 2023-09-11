class WordDictionary {
    Node head;
    Node dummy = new Node();

    class Node {
        Node[] children;
        boolean end;

        Node() {
            this.children = new Node[26];
            this.end = false;
        }
    }

    public WordDictionary() {
        head = dummy;        
    }
    
    public void addWord(String word) {
        Node next = head;
        for (int i=0;i<word.length();i++) {
            int pos = word.charAt(i)-'a';
            if (next.children[pos] == null) {
                next.children[pos] = new Node();
            }
            next = next.children[pos];
        }
        next.end = true;
    }

    public boolean search(String word) {
        return searchDFS(word, 0, head);
    }
    
    public boolean searchDFS(String word, int index, Node next) {
        if (index == word.length()) { return next.end; }            
        char now = word.charAt(index);
        if (now == '.') { // 와일드 카드라면
            for (int i=0;i<26;i++) { // 소문자 26개
                // 리프 노드가 아니고 && 다음 노드 재귀로 검색한 결과가 false 가 아니라면
                if (next.children[i] != null && searchDFS(word, index+1, next.children[i])) {
                    return true;
                }
            }
            return false; // 모든 알파벳을 체크했는데 true가 없으면 false
        } else { // 와일드 카드가 아니라면
            if (next.children[now-'a'] == null) { return false; } // 이 문자가 없으면 false
            return searchDFS(word, index+1, next.children[now-'a']); // 이 문자가 있으면 재귀 호출
        }
    }
}

class Trie {

    Node head;
    Node dummy = new Node(' '); // Dummy Head용 빈 노드.(들어올 자료들은 모두 영문 소문자만 들어온다.)

    class Node { // Node 클래스
        char val; // 값(생략 가능)
        HashMap<Character, Node> children;
        boolean end = false;

        Node(char val) {
            this.val = val;
            this.children = new HashMap<Character, Node>();
            this.end = false;
        }
    }

    public Trie() {
        head = dummy;
    }
    
    public void insert(String word) {
        HashMap<Character, Node> next = head.children; // 더미 헤드의 칠드런(다음 노드들)

        for (int i=0;i<word.length();i++) { // 문자열을 순회하며 알파벳 체크
            char now = word.charAt(i); // 지금 체크하는 알파벳
            if (next.containsKey(now)) { // 다음 노드들중에 이 알파벳이 포함되어 있는지
                // 이미 존재하는 노드
                if (i==word.length()-1) { // 현재 문자열의 마지막 문자라면
                    next.get(now).end = true; // end를 true로 변경
                }
                next = next.get(now).children; // 다음 노드들 현재 노드의 children으로 변경
            } else {
                // 아직 이 문자의 노드가 없다면
                Node input = new Node(now); // 추가할 노드
                if (i==word.length()-1) { input.end = true; } // 마지막 문자라면 end = true;
                next.put(now, input); // 추가
                next = next.get(now).children; // 다음 노드들 현재 추가한 노드의 children으로 변경
            }
        }
    }
    
    public boolean search(String word) {
        HashMap<Character, Node> next = head.children; // 더미 헤드의 칠드런(다음 노드들)
        for (int i=0;i<word.length();i++) {
            char now = word.charAt(i);
            if (next.containsKey(now)) { // 키가 있다면
                if (i == word.length()-1) { // 마지막 문자열이라면
                    if (next.get(now).end) { // end가 true라면(정확히 이 문자열이 입력된 적이 있다면)
                        return true;
                    } else {                         
                        return false;
                    }
                }
                next = next.get(now).children; // 다음 노드들 현재 추가한 노드의 children으로 변경
            } else {                
                return false; // 없다면 바로 false 리턴하여 탈출
            }
        }
        return true; // 끝까지 체크 후 false 아니라면 true
    }
    
    public boolean startsWith(String prefix) {
        HashMap<Character, Node> next = head.children; // 더미 헤드의 칠드런(다음 노드들)
        for (int i=0;i<prefix.length();i++) {
            char now = prefix.charAt(i);
            if (next.containsKey(now)) { // 키가 있다면
                next = next.get(now).children; // 다음 노드 탐색
            } else {
                return false; // 없다면 바로 false 리턴하여 탈출
            }
        }
        return true; // 끝까지 체크 후 false 아니라면 true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class Trie {

    Node head;
    Node dummy = new Node(' ');
    class Node {
        char val;
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
        HashMap<Character, Node> next = head.children;

        for (int i=0;i<word.length();i++) {
            char now = word.charAt(i);
            if (next.containsKey(now)) {
                if (i==word.length()-1) {
                    next.get(now).end = true;
                }
                next = next.get(now).children;
            } else {
                Node input = new Node(now);
                if (i==word.length()-1) { input.end = true; }
                next.put(now, input);
                next = next.get(now).children;
            }
        }
    }
    
    public boolean search(String word) {
        HashMap<Character, Node> next = head.children;
        for (int i=0;i<word.length();i++) {
            char now = word.charAt(i);
            if (next.containsKey(now)) {
                if (i == word.length()-1) {
                    if (next.get(now).end) {
                        return true;
                    } else {                         
                        return false;
                    }
                }
                next = next.get(now).children;
            } else {                
                return false;
            }
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        HashMap<Character, Node> next = head.children;
        for (int i=0;i<prefix.length();i++) {
            char now = prefix.charAt(i);
            if (next.containsKey(now)) {
                next = next.get(now).children;
            } else {                
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
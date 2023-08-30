class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i=0;i<tokens.length;i++) {
            if ("+-*/".contains(tokens[i])) {
                int e2 = s.pop();
                int e1 = s.pop();
                int ne=0;
                if (tokens[i].equals("+")) {
                    ne = e1+e2;
                } else if (tokens[i].equals("-")) {
                    ne = e1-e2;
                } else if (tokens[i].equals("*")) {
                    ne = e1*e2;
                } else if (tokens[i].equals("/")) {
                    ne = e1/e2;
                }
                s.push(ne);
            } else {             
                s.push(Integer.parseInt(tokens[i]));   
            }
        }
        return s.pop();
    }
}
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i=0;i<tokens.length;i++) {
            // 토큰이 연산자라면 직전 2개 요소 꺼내서 연산
            if ("+-*/".contains(tokens[i])) {
                int e2 = s.pop(); // 더 가까운(스택에서 먼저 나오는) 요소가 / 연산시 분모로
                int e1 = s.pop();
                int ne = 0; // 연산 결과
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
                s.push(Integer.parseInt(tokens[i])); // 토큰이 연산자가 아니라면 정수로 스택에 삽입
            }
        }
        return s.pop();
    }
}
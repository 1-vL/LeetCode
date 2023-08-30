class MinStack {
    Stack<Integer[]> internal_stack;

    public MinStack() {
        internal_stack = new Stack<Integer[]>();
    }
    
    public void push(int val) {
        internal_stack.push(new Integer[] {val, Math.min(getMin(), val)});
    }
    
    public void pop() {
        internal_stack.pop();
    }
    
    public int top() {
        return internal_stack.peek()[0];
    }
    
    public int getMin() {
        if (internal_stack.size()==0) return Integer.MAX_VALUE;
        return internal_stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
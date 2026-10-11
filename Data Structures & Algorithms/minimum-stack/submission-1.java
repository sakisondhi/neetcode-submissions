class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    // Stack<Integer> st;
    // Queue<Integer> minValue;

    // public MinStack() {
    //     st = new Stack<>();
    //     minValue = new PriorityQueue<>();
    // }
    
    // public void push(int val) {
    //     st.push(val);
    //     minValue.offer(val);
    // }
    
    // public void pop() {
    //     minValue.remove(st.pop());
    // }
    
    // public int top() {
    //     return st.peek();
    // }
    
    // public int getMin() {
    //     return minValue.peek();
    // }
}

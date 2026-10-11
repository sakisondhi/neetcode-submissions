class MinStack {
    Stack<Integer> st;
    Queue<Integer> minValue;

    public MinStack() {
        st = new Stack<>();
        minValue = new PriorityQueue<>();
    }
    
    public void push(int val) {
        st.push(val);
        minValue.offer(val);
    }
    
    public void pop() {
        minValue.remove(st.pop());
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minValue.peek();
    }
}

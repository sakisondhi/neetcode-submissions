class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[temperatures.length];

        st.push(0);
        for(int i=1; i<temperatures.length; i++){
            
            
            while(!st.isEmpty() && temperatures[st.peek()]< temperatures[i]){
                int top=st.peek();
                res[top] = i-top;
                st.pop();
            }
            st.push(i);
            
        }

        return res;

    }
}

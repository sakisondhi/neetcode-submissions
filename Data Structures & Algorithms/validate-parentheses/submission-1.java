class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            Character ch= s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') st.push(ch);
            else if(ch == ')' || ch == '}' || ch == ']'){
                if(st.empty()) return false;
                else{
                    char top = st.peek();
                    if(top =='(' && ch == ')') st.pop();
                    else if(top =='{' && ch == '}') st.pop();
                    else if(top =='[' && ch == ']') st.pop();
                    else return false;
                }
            }else return false;
        }

        if(st.empty()) return true;

        return false;
    }
}

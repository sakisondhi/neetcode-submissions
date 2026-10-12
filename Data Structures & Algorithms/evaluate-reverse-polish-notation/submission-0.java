class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int res = 0, i = 0;
        while(i<tokens.length){
            String token = tokens[i];

            if (token.equals("+") || token.equals("-")
                    || token.equals("*") || token.equals("/")) {
                int a = stack.pop(); // Right operand
                int b = stack.pop(); // Left operand

                if (token.equals("+")) stack.push(b + a);
                else if (token.equals("-")) stack.push(b - a);
                else if (token.equals("*")) stack.push(b * a);
                else stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(token));
            }
            i++;
        }

        return stack.pop();
    }
}

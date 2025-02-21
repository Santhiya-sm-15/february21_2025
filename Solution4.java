class Solution {
    static boolean isBalanced(String s) {
        Stack<Character> st=new Stack<>();
        int i;
        for(i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='[' || c=='{' || c=='(')
                st.push(c);
            else if(c=='}' || c==']' || c==')')
            {
                if(!st.isEmpty() && ((st.peek()=='(' && c==')') || (st.peek()=='{' && c=='}') || (st.peek()=='[' && c==']')))
                    st.pop();
                else
                    return false;
            }
        }
        return st.isEmpty();
    }
}
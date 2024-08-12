/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
*/
class Solution {
    public boolean valid(String s)
    {
        Stack<Character> st=new Stack<>();
         char c;
        for(int i=0;i<s.length();i++)
        {
           c=s.charAt(i);
            if(c=='(' || c=='{' || c=='[')
            {
               st.push(c);
            }
            else
            {
                if(st.isEmpty()) return false;
                char t=st.peek();
                if((c==')' && t=='(') ||(c==']' && t=='[') || (c=='}' && t=='{'))
                {
                       st.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    public boolean isValid(String s) {
        return valid(s);
    }
}

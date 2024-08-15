/*
Input: 
*-A/BC-/AKL
Output: 
ABC/-AK/L-*
*/

class Solution {
    static String prefixtopostfix(String exp)
    {
        Stack<String> stack=new Stack<>();
        int i=exp.length()-1;
        while(i>=0)
        {
            char c=exp.charAt(i);
            if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))
            {
                stack.push(c+"");
            }
            else
            {
                String t1=stack.pop();
                String t2=stack.pop();
                stack.push(t1+t2+c);
            }
            i--;
        }
        return stack.pop();
    }
    static String preToPost(String exp) {
        // code here
        return prefixtopostfix(exp);
    }
}

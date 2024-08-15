
/*
Input: 
ABC/-AK/L-*
Output: 
*-A/BC-/AKL
*/
class Solution {
    static String postfixtoprefix(String exp)
    {
        Stack<String> stack=new Stack<>();
        for(int i=0;i<exp.length();i++)
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
               
               String res=c+t2+t1;
               stack.push(res);
           }
        }
        return stack.pop();
    }
    static String postToPre(String exp) {
        // code here
        return postfixtoprefix(exp);
    }
}

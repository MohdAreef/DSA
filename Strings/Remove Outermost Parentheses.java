/*
A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
*/

class Solution {
    public String removeOuterParentheses(String s) 
    {
       
    //    String s="";
    StringBuffer stringBuffer = new StringBuffer();
    int cnt=0;
       for(int i=0;i<s.length();i++)
       {
       if(s.charAt(i)=='(')
       {
        if(cnt>0)
        {
        stringBuffer.append('(');
        }
        cnt++;
       }
       else
       {

           cnt--;
           if(cnt>0)
           {
            stringBuffer.append(')');
           }
         
       }
        
       }
       String res=stringBuffer.toString();
       return res;

    
    }
}

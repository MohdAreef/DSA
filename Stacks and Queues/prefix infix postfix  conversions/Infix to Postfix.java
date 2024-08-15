class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static int priority(char c)
    {
        if(c=='^')
        {
            return 3;
        }
        else if(c=='*' || c=='/')
        {
            return 2;
        }
        else if(c=='+' || c=='-')
         return 1;
         else return -1;
    }
    public static String infix2post(String exp)
    {
        
        int n=exp.length();
        StringBuffer ans=new StringBuffer();
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            char c=exp.charAt(i);
            if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))
            {
                ans.append(c);
            }
            else if(c=='(')
            {
                stack.push(c);
            }
            else if(c==')')
            {
                while(!stack.isEmpty() && stack.peek()!='(')
                {
                    ans.append(stack.pop());
                  
                }
                stack.pop();
            }
            
            else
            {
               while(!stack.isEmpty() && priority(c)<=priority(stack.peek()))
               {
                   ans.append(stack.pop());
               }
               stack.push(c);
            }
        }
        
        while(!stack.isEmpty())
        {
           ans.append(stack.pop());   
        }
        
        return ans.toString();
    }
    public static String infixToPostfix(String exp) {
        // Your code here
        
        return infix2post(exp);
    }
}

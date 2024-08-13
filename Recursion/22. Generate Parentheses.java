/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
*/

class Solution {
    public void generate(int open,int close,Stack<Character> stack,int n,ArrayList<String> res,String sb)
    {
       //base condition
       if(sb.length()==2*n)
       {
          if(stack.size()==0)
          {
         res.add(sb.toString());
          }
         return ;
       }

        //explore
        //pick open
        if(open>0)
        {
            stack.push('(');
            generate(open-1,close,stack,n,res,sb+"(");
            stack.pop();
        }
        //pick close
        if(close>0)
        {
            // boolean flag=false;
            // if(!stack.isEmpty())
            // { stack.pop(); 
            //   flag=true;
            // }
            // generate(open,close-1,stack,n,res,sb+")");
            // if(flag==true)
            // {
            //     stack.push('(');
            // }
            if(!stack.isEmpty())
            {
                stack.pop();
                generate(open,close-1,stack,n,res,sb+")");
                stack.push('(');

            }

        }

    }

    public List<String> generateParenthesis(int n) {
        
        Stack<Character> stack=new Stack<>();
        ArrayList<String> res=new ArrayList<>();
        String sb=new String();


        generate(n,n,stack,n,res,sb);

        return res;       
    }
}

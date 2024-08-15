class Solution {
     static String prefixtoinfix(String exp)
    {
        Stack<String> stack=new Stack<>();
        int n=exp.length();
        for(int i=n-1;i>=0;i--)
        {
            char c=exp.charAt(i);
            if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))
            {
                stack.push(c+"");
            }
            else
            {
                String t2=stack.pop();
                String t1=stack.pop();
                String res="("+t2+c+t1+")";
                stack.push(res);
            }
        }
        return stack.pop();
    }
    static String preToInfix(String exp) {
        // code here
        return prefixtoinfix(exp);
    }
}

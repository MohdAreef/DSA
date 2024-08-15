class Solution {
    static String postfixtoinfix(String exp)
    {
        Stack<String> stack=new Stack();
        StringBuffer sb=new StringBuffer();
        //scan from left to right
        
        int n=exp.length();
        for(int i=0;i<n;i++)
        {
            char c=exp.charAt(i);
            
            if((c>='a' && c<='z') || (c>='A' && c<='Z' ) || (c>='0' && c<='9'))
            {
                stack.push(c+"");
            }
            else 
            {
                String t2=stack.pop();
                String t1=stack.pop();
                String res="(" + t1 + c + t2 + ")";
                stack.push(res);
            
            }
            
        }
        return stack.pop();
    }
    static String postToInfix(String exp) {
        // code here
        return postfixtoinfix(exp);  
    }
}

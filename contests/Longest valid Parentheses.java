/*
Given a string str consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.

A parenthesis string is valid if:

For every opening parenthesis, there is a closing parenthesis.
Opening parenthesis must be closed in the correct order.
Examples :

Input: str = ((()
Output: 2
Explaination: The longest valid parenthesis substring is "()".
*/

class Solution{
    
    static int max(String s)
    {
        int left=0,right=0,maxi=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(') left++;
            else right++;
            
            if(left==right) 
            {
                maxi=Math.max(maxi,left*2);
            }
            if(right>left) 
            {
                left=0;
                right=0;
            }
            
        }
        
        left=0;
        right=0;
        
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='(') left++;
            else right++;
            
            if(left==right) 
            {
                maxi=Math.max(maxi,left*2);
            }
            if(right<left) 
            {
                left=0;
                right=0;
            }
            
        }
        
        return maxi;
    }
    static int maxLength(String S){
        // code here
        return max(S);
    }
}

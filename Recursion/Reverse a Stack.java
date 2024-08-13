// You are given a stack St. You have to reverse the stack using recursion.
class Solution
{ 
    static void insertlast(int x,Stack<Integer> s)
    {
        if(s.isEmpty())
        {
            s.push(x);
            return;
        }
        int y=s.pop();
        insertlast(x,s);
        s.push(y);
    }
    static void reversestack(Stack<Integer> s)
    {
        if(s.isEmpty()) return ;
        
        int x=s.pop();
        reversestack(s);
        insertlast(x,s);
        
    }
    static void reverse(Stack<Integer> s)
    {
        // add your code here
       
        reversestack(s);
      
       
    }
}

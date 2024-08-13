// Given a stack, the task is to sort it such that the top of the stack has the greatest element.
class GfG {
    public void insert(int x,Stack<Integer> s)
    {
        Stack<Integer> stack=new Stack<>();
        while(!s.isEmpty() && s.peek()>x)
        {
            stack.push(s.pop());
        }
        s.push(x);
        while(!stack.isEmpty())
        {
            s.push(stack.pop());
        }
    }
    public void stacksort(Stack<Integer> s)
    {
        if(s.size()==1)
        return ;
        
        //explore
        int x=s.pop();
        stacksort(s);
        insert(x,s);
    }
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        stacksort(s);
        return s;
    }
}

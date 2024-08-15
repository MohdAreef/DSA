/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.
*/

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class MinStack {
    Pair[] stack;
    int top;

    public MinStack() {
        stack = new Pair[30000 + 1];

        top = -1;
        mini = Integer.MAX_VALUE;
    }

    public void push(int val) {
        top++;
        if (top == 0) {
            stack[top] = new Pair(val, val);

        } else {
            stack[top] = new Pair(val, Math.min(val, stack[top - 1].y));

        }
    }

    public void pop() {

        stack[top] = null;

        if (top < 0) {
            top = -1;
        } else
            top--;

    }

    public int top() {

        if (top <= -1)
            return -1;
        Pair temp = stack[top];
      
        return temp.x;

    }

    public int getMin() {
        if (top == -1)
            return -1;
        Pair temp = stack[top];
     
        return temp.y;

    }
}

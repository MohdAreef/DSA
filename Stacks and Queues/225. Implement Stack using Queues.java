// Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
class MyStack {
    Queue<Integer> q1, q2;

    public MyStack() {

        q1 = new LinkedList<>();
        q2 = new LinkedList<>();

    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        if (q1.isEmpty())
            return -1;
        while (q1.size() != 1) {
            q2.add(q1.poll());
        }
        int r = q1.poll();
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
        return r;

    }

    public int top() {
        if (q1.isEmpty())
            return -1;
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int r = q1.poll();
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
        q1.add(r);
        return r;

    }

    public boolean empty() {

        if (q1.isEmpty() == true)
            return true;
        else
            return false;

    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

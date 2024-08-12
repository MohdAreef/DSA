class MyQueue
{
    QueueNode front=null, rear=null;
    
    //Function to push an element into the queue.
	void push(int a)
	{
        // Your code here
        if(front==null)
        {
            QueueNode temp=new QueueNode(a);
            front=temp;
            rear=temp;
        }
        else
        {
             QueueNode temp=new QueueNode(a);
             rear.next=temp;
             rear=temp;
        }
        
        
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        // Your code here
        if(front==null) return -1;
        int x=front.data;
        front=front.next;
        return x;
        
           
	}
}





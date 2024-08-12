class MyQueue {

    int front, rear;
	int arr[] = new int[100005];

    MyQueue()
	{
		front=-1;
		rear=-1;
	}
	
	//Function to push an element x in a queue.
	void push(int x)
	{
	    // Your code here
	    if(front==-1 && rear==-1)
	    {
	        rear++;
	        arr[rear]=x;
	        front++;
	    }
	    else 
	    {
	        rear++;
	        arr[rear]=x;
	       
	    }
	    
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		// Your code here
		if(front==-1 && rear==-1) return -1;
		int r=arr[front];
		front++;
		if(front>rear)
		{
		    rear=-1;
		    front=-1;
		}
		return r;
	} 
}





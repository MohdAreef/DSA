/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
  */

class Pair
{
    int value,index=0;
    Pair(int i,int index)
    {
        this.value=i;
        this.index=index;
    }
}
//we can optimize the below solution ( only using one stack)
class Solution {
    public int[] goodasteroids(int[] arr)
    {
        Stack<Pair> forward=new Stack<>();
        Stack<Pair> backward=new Stack<>();
        int n=arr.length;
        int r=0;
        while(r<n)
        {
            if(arr[r]>0)
            {
                forward.push(new Pair(arr[r],r));
                r++;
            }
            else
            {
                int a=Math.abs(arr[r]);
                boolean flag=false;
                while(!forward.isEmpty() && forward.peek().value<=a)
                {
                    if(forward.peek().value==a)
                    {
                        forward.pop();
                    
                        flag = true;
                        
                        break;
                    }
                    else
                    {
                        forward.pop();
                    }
                }
                if(flag==false && forward.isEmpty())
                {
                  
                    backward.push(new Pair(arr[r],r));
                }
                  r++;

            }
        }
        int size=backward.size() + forward.size();
        int[] res=new int[size];
        int j=size-1;
        while(!forward.isEmpty() && !backward.isEmpty())
        {
            if(forward.peek().index>backward.peek().index)
            {
                res[j--]=forward.pop().value;
            }
            else
            {
                res[j--]=backward.pop().value;
            }
        }
        while(!forward.isEmpty())
        {
            res[j--]=forward.pop().value;
            
        }
        while(!backward.isEmpty())
        {
            res[j--]=backward.pop().value;
        }
        return res;
    }
    public int[] asteroidCollision(int[] asteroids) {


        return goodasteroids(asteroids);


        
    }
}

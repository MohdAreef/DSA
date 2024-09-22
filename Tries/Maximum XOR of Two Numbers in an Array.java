/*
An array ‘A’ of ‘N’ integers is provided. Return the maximum possible number which can be created by taking bitwise XOR of any 2 integers of the array.

Example:
If the array is 2,5 and 6

2 XOR 5 is 7
2 XOR 6 is 4
5 XOR 6 is 3

Hence the answer is 7.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3
2 1 4
Sample Output 1:
6
*/

class Node
{
    Node[] links;
    Node()
    {
        links=new Node[2];
    }
}
class Trai
{
    Node root;
    Trai()
    {
        root=new Node();
    }
    public void insert(int n)
    {
        Node curr=root;
        for(int i=31;i>=0;i--)
        {
           int index=n&(1<<i);
           if(index==(1<<i))
           {
               index=1;
           }
           else index=0;

           if(curr.links[index]==null)
           {
               Node temp=new Node();
            curr.links[index]=temp;
           }
           curr=curr.links[index];
        }
    }
    public int maxxor(int n)
    {
         Node curr=root;
         int maxi=0;
       
        for(int i=31;i>=0;i--)
        {
           int index=n&(1<<i);
           if(index==(1<<i))
           index=1;
           else index=0;

           int opposite=1-index;

           if(curr.links[opposite]!=null)
           {
        
           curr=curr.links[opposite];
          maxi= maxi | (1<<i);
     
           }
           else
           {
           curr=curr.links[index];
      
           }
        } 
        return maxi;
    }
}

public class Solution {

    public static int maximumXor(int []A) {
        // Write your code here.
        Trai tr=new Trai();
         for(int i=0;i<A.length;i++)
         {
             tr.insert(A[i]);
         }
         int maxi=0;
         for(int i=0;i<A.length;i++)
         {
             int ans=tr.maxxor(A[i]);
             maxi=Math.max(maxi,ans);
         }
         return maxi;
    }
}

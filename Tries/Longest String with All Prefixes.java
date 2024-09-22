import java.util.* ;
import java.io.*; 
class Node 
{
    Node[] links;
    boolean flag;
 
    Node()
    {
        links=new Node[26];
        flag=false;
    }

    boolean containsKey(char c)
    {
        if(links[c-'a']==null) return false;
        return true;
    }
}

class Trei
{
    Node root;
    Trei()
    {
      root=new Node();
    } 

    public void insert(String str)
    {
        Node curr=root;
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(!curr.containsKey(c))
            {
               Node temp=new Node();
               curr.links[c-'a']=temp;

            }
            curr=curr.links[c-'a'];
        }
        curr.flag=true;
    } 
    
    public boolean search(String str)
    {
        Node curr=root;
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            curr=curr.links[c-'a'];
            if(curr.flag==false) return false;

        }

        return true;
    }    
}

class Solution {

  public static String completeString(int n, String[] a) {
    // Write your code here.
        Trei tr=new Trei();
     
       
        
        for(int i=0;i<a.length;i++)
        {
            tr.insert(a[i]);
        }
      
        
        String longest="";
        for(int i=0;i<a.length;i++)
        {
            if(tr.search(a[i]))
            {
                if(a[i].length() > longest.length())
                {
                    longest=a[i];
                }
                else if(a[i].length()==longest.length())
                {
                    if(a[i].compareTo(longest)<0)
                      longest=a[i];
                }
            }
        }

      if(longest.equals("")) 
      return "None";
      return longest;

  }
}

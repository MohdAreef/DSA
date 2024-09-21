import java.util.* ;
import java.io.*; 
 class Node
{
    Node[] arr;
    int cp,cw;

    Node()
    {
        arr=new Node[26];
        cp=0;
        cw=0;
    }

    boolean containsKey(char c)
    {
       return arr[c-'a']==null ? false : true;
    }

    Node getNext(char c)
    {
        return arr[c-'a'];
    }


}
public class Trie {
    Node root;
    public Trie() {
        // Write your code here.
        root=new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node curr=root;

        for(int i=0;i<word.length();i++)
        {
            if(curr.containsKey(word.charAt(i))==false)
            {
                Node temp=new Node();
                curr.arr[word.charAt(i)-'a']=temp;
            }

            curr=curr.getNext( word.charAt(i));

            curr.cp=curr.cp+1;
        }
            
        curr.cw=curr.cw+1;

     
     }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node temp=root;
        for(int i=0;i<word.length();i++)
        {
            if(temp.containsKey(word.charAt(i))==false)
            {
            return 0;
            }
            temp=temp.getNext(word.charAt(i));
        }
        return temp.cw;
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node temp=root;
        for(int i=0;i<word.length();i++)
        {
            if(temp.containsKey(word.charAt(i))==false)
            {
            return 0;
            }
            temp=temp.getNext( word.charAt(i));
        }
       return  temp.cp;

    }

    public void erase(String word) {
        // Write your code here.
        Node temp=root;
        for(int i=0;i<word.length();i++)
        {
            if(temp.containsKey(word.charAt(i))==false)
            {
            break;
            }
            temp=temp.getNext( word.charAt(i));
            temp.cp-=1;
        }
        temp.cw-=1;

    }

}

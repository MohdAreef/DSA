/*
The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings.
*/

class Solution {
    public int find(String s)
    {
       
       int n=s.length();
       int sum=0;
        for(int i=0;i<n;i++)
        {
             HashMap<Character,Integer> map=new HashMap<>();
            
           for(int j=i;j<n;j++)
           {
            char c=s.charAt(j);
            if(map.containsKey(c))
            {
                map.put(c,map.get(c)+1);
               
            }
            else
            {
                map.put(c,1);
            }
            int mini=Integer.MAX_VALUE;
            int maxi=Integer.MIN_VALUE;
            for(Map.Entry<Character,Integer> entry: map.entrySet())
            {
            maxi=Math.max(maxi,entry.getValue());
            mini=Math.min(mini,entry.getValue());
            }  
            sum+=(maxi-mini);
           }
        }
        return sum;
    }
    public int beautySum(String s) {
         return find(s);
        
    }
}

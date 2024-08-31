/*
Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that have exactly k distinct characters. 

Example 1:

Input: S = "aba", K = 2
Output:3
Explanation:The substrings are: "ab", "ba" and "aba".
Input: S = "abaaca", K = 1
Output: 7
Explanation: The substrings are: "a", "b", "a", "aa", "a", "c", "a". 
*/

class Solution
{
    long count(String s,int k)
    {
        int i=0,j=0;
        int n=s.length();
        long count=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(j<n)
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
            
            while(map.size()>k)
            {
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i))==0)
                {
                    map.remove(s.charAt(i));
                }
                i++;
                
            }
            
            if(map.size()<=k)
            {
                count+=(j-i+1);
            }
           
            j++;
        }
        return count;
        
    }
    long substrCount (String S, int K) {
        // your code here
        long a =count(S,K);
        long b=count(S,K-1);
       
        return a-b;
    }
}

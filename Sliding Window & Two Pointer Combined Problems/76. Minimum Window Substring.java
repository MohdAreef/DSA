/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is 
included in the window. If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
*/

class Solution {
    public String minWindow(String s, String t) {
        int l=0,r=0,count=0 , minlen=Integer.MAX_VALUE,index=-1;
        int m=s.length(),n=t.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        while(r<m)
        {
            char c=s.charAt(r);
            if(map.containsKey(c))
            {
                if(map.get(c) > 0)
                 count++;

                map.put(c,map.get(c)-1);
            }

            //shrink
            while(count==n)
            {
                 int currlen= r-l+1;
                 
                 if(currlen < minlen)
                 {
                    minlen=currlen;
                    index=l;
                 }

                 char temp=s.charAt(l);
                 if(map.containsKey(temp ))
                 {
                    map.put(temp,map.get(temp)+1);
                    if(map.get(temp) > 0) count--;
                 }

                 l++;
                 
            }

            r++;
        }
        String ans="";
        if(index==-1) return ans;
        ans=s.substring(index,index+minlen);
        return ans;
        
    }
}

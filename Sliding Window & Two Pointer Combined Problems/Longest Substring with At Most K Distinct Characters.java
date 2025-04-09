/*
Problem statement
You are given a string 'str' and an integer ‘K’. Your task is to find the length of the largest substring with at most ‘K’ distinct characters.

For example:
You are given ‘str’ = ‘abbbbbbc’ and ‘K’ = 2, then the substrings that can be formed are [‘abbbbbb’, ‘bbbbbbc’]. Hence the answer is 7.
Sample Input 1:  
2
2
abbbbbbc
3
abcddefg
Sample Output 1:
7
4
Explanation:
For the first test case, ‘str’ = ‘abbbbbbc’ and ‘K’ = 2, then the substrings that can be formed are [‘abbbbbb’, ‘bbbbbbc’]. Hence the answer is 7.

For the second test case, ‘str’ = ‘abcddefg’ and ‘K’ = 3, then the substrings that can be formed is [‘cdde’, ‘ddef’]. Hence the answer is 4.
Sample Input 2:
2
3
aaaaaaaa
1
abcefg
Sample Output 2:
8   
1   

Hints:
1. Try to think of a brute force approach.
2. Try to think of a two-pointer solution.

*/
// problem link  https://www.naukri.com/code360/problems/distinct-characters_2221410?leftPanelTabValue=PROBLEM

import java.util.*;
public class Solution {

	public static int kDistinctChars(int k, String s) {
		// Write your code here
		     int l=0,r=0,n=s.length();
        int maxlen=0;
        HashMap<Character,Integer> map=new HashMap<>();

        while(r<n)
        {
            char c=s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            
            while(map.size() > k)
            {
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                
                if(map.get(s.charAt(l))==0) map.remove(s.charAt(l));
                
                l++;
            }
            
            
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
	}

}




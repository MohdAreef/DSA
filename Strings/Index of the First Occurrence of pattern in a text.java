/*
Given two strings text and pattern, find the first index where pattern exactly matches with any substring of text. 

Return -1 if pattern doesn't exist as a substring in text.
*/
class Solution {
    public int find(String text,String pat)
    {
        int n=text.length();
        int l=0,r=0;
        for(int i=0;i<n;i++)
        {
            if(text.charAt(i)==pat.charAt(0))
            {
               int j=0;
                for( j=0;j<pat.length() && (i+j)<n  ;j++)
                {
                    if(  text.charAt(j+i)!=pat.charAt(j))
                    {
                        break;
                    }
                }
                if(j==pat.length()) return i;
            }
        }
        return -1;
    }
    public int findMatching(String text, String pat) {
        // Code here
        return find(text,pat);
    }
}

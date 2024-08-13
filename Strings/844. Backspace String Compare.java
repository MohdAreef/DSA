/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
*/

class Solution {
    public String getOriginal(String s)
    {
        StringBuffer sb=new StringBuffer();

        int i=s.length()-1;
        int hashcount=0;
        while(i>=0)
        {
            if(s.charAt(i)=='#') hashcount++;

            else
            {
                if(hashcount>0)
                {
                    hashcount--;
                }
                else
                {
                    sb.insert(0,s.charAt(i));
                }
            }
            i--;
        }
        return sb.toString();
    }
    public boolean backspaceCompare(String s, String t) {
        
        s=getOriginal(s);
        t=getOriginal(t);
        if(s.equals(t))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}


OPTIMAL SOLUTION
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sBack = 0, tBack = 0;
        int x = s.length() - 1, y = t.length() - 1;

        while (x >= 0 || y >= 0) {
            while (x >= 0) {
                if (s.charAt(x) == '#') {
                    sBack++;
                    x--;
                } else if (sBack > 0) {
                    sBack--;
                    x--;
                } else {
                    break;
                }
            }

            while (y >= 0) {
                if (t.charAt(y) == '#') {
                    tBack++;
                    y--;
                } else if (tBack > 0) {
                    tBack--;
                    y--;
                } else {
                    break;
                }
            }

            if (x >= 0 && y >= 0 && s.charAt(x) != t.charAt(y)) {
                return false;
            }

            if ((x >= 0 && y < 0) || (y >= 0 && x < 0)) {
                return false;
            }
            x--;
            y--;
        }

        return true;
    }
}

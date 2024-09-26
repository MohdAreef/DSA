/*
You are given a binary strings.

You can perform the following operation on the string any number of times:

Choose any index i from the string where i + 1 < s.length such that s[i] == '1' and s[i + 1] == '0'.
Move the character s[i] to the right until it reaches the end of the string or another '1'. For example, for s = "010010", if we choose i = 1, the 
resulting string will be s = "000110".
Return the maximum number of operations that you can perform.
*/

class Solution {
    public int max(String s)
    {
        int ones=0,zeros=0,count=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='1')
            {
                if(zeros!=0)
                {
                    count=count+ones;
                    zeros=0;
                }
                ones++;
            }
            else
            {
                zeros++;
            }
        }
        if(zeros!=0)
        {
            count+=ones;
        }
        return count;
    }
    
    public int maxOperations(String s) {
        return max(s);
    }
}

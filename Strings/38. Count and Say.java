/*
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the run-length encoding of countAndSay(n - 1).
Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with 
the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" 
we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".

Given a positive integer n, return the nth element of the count-and-say sequence.

Example 1:

Input: n = 4

Output: "1211"

Explanation:

countAndSay(1) = "1"
countAndSay(2) = RLE of "1" = "11"
countAndSay(3) = RLE of "11" = "21"
countAndSay(4) = RLE of "21" = "1211"
*/

class Solution {
    public String count(int n) {
        StringBuffer sb = new StringBuffer();
        sb.append('1');
        for (int i = 2; i <= n; i++) {
            int size = sb.length();
            int j = 0;
            int cnt = 1;
            int index = 0;
            StringBuffer temp = new StringBuffer();
            while (j < size) {
                if (j + 1 < size && sb.charAt(j) == sb.charAt(j + 1)) {
                    cnt++;
                } else if (j + 1 < size) {
                    temp.append(cnt);
                    temp.append(sb.charAt(index));
                    index = j + 1;
                    cnt = 1;
                }
                j++;
            }
            temp.append(cnt);
            temp.append(sb.charAt(index));

            sb = new StringBuffer(temp);

        }
        return sb.toString();
    }

    public String countAndSay(int n) {

        return count(n);

    }
}

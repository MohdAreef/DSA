/*
You are given an array words of size n consisting of non-empty strings.

We define the score of a string word as the number of strings words[i] such that word is a prefix of words[i].

For example, if words = ["a", "ab", "abc", "cab"], then the score of "ab" is 2, since "ab" is a prefix of both "ab" and "abc".
Return an array answer of size n where answer[i] is the sum of scores of every non-empty prefix of words[i].

Note that a string is considered as a prefix of itself.
Example 1:

Input: words = ["abc","ab","bc","b"]
Output: [5,4,3,2]
Explanation: The answer for each string is the following:
- "abc" has 3 prefixes: "a", "ab", and "abc".
- There are 2 strings with the prefix "a", 2 strings with the prefix "ab", and 1 string with the prefix "abc".
The total is answer[0] = 2 + 2 + 1 = 5.
- "ab" has 2 prefixes: "a" and "ab".
- There are 2 strings with the prefix "a", and 2 strings with the prefix "ab".
The total is answer[1] = 2 + 2 = 4.
- "bc" has 2 prefixes: "b" and "bc".
- There are 2 strings with the prefix "b", and 1 string with the prefix "bc".
The total is answer[2] = 2 + 1 = 3.
- "b" has 1 prefix: "b".
- There are 2 strings with the prefix "b".
The total is answer[3] = 2.
*/


class Node {
    Node[] arr;
    int pre = 0;

    Node() {
        arr = new Node[26];
        pre = 0;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (curr.arr[c - 'a'] == null) {
                curr.arr[c - 'a'] = new Node();
            }
            curr = curr.arr[c - 'a'];
            curr.pre++;
        }
    }

    public int search(String str) {
        Node curr = root;
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (curr.arr[c - 'a'] == null) {
                curr.arr[c - 'a'] = new Node();
            }
            sum += curr.pre;
            curr = curr.arr[c - 'a'];

        }
        sum += curr.pre;
        return sum;
    }
}

class Solution {
    public int[] sum(String[] words) {
        Trie tr = new Trie();
        for (int i = 0; i < words.length; i++) {
            tr.insert(words[i]);
        }
        int[] ans = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ans[i] = tr.search(words[i]);
        }
        return ans;
    }

    public int[] sumPrefixScores(String[] words) {
        return sum(words);
    }
}

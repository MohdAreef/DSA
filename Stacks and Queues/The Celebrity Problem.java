/*
A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people. A square matrix mat[][] (n*n) 
is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. You need to return 
the index of the celebrity in the party, if the celebrity does not exist, return -1.

Note: Follow 0-based indexing.

Examples:

Input: mat[][] = [[1, 1, 0], [0, 1, 0], [0, 1, 1]]
Output: 1
Explanation: 0th and 2nd person both know 1st person. Therefore, 1 is the celebrity person. 
*/

class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int n=mat.length;
        int[] indegree=new int[n];
        int[] outdegree=new int[n];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j && mat[i][j]==1)
                {
                    indegree[j]++;
                    outdegree[i]++;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==(n-1) && outdegree[i]==0) return i;
        }
        return -1;
    }
}

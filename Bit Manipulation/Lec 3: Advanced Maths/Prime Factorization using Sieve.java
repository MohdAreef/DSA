/*
You are given a positive number N. Using the concept of Sieve, compute its prime factorisation.

Example:

Input: 
N = 12246
Output: 
2 3 13 157
Explanation: 
2*3*13*157 = 12246 = N.
*/

// Using seive method
class Solution {
    // You must implement this function
    static void sieve() {}

    static List<Integer> findPrimeFactors(int n) {
        // code here
        int[] arr=new int[n+1];
        Arrays.fill(arr,0);
        
        List<Integer> ans=new ArrayList<>();
        for(int i=2;i<=n;i++)
        {
            while(n%i==0)
            {
                arr[i]++;
                ans.add(i);
                n=n/i;
            }
        }
        return ans;
    }
}

//Using normal maths
class Solution {
    // You must implement this function
    static void sieve() {}

    static List<Integer> findPrimeFactors(int n) {
        // code here
         List<Integer> ans=new ArrayList<>();
        for(int i=2;i<=n;i++)
        {
            while(n%i==0)
            {
                ans.add(i);
                n=n/i;
            }
        }
        return ans;
    }
}

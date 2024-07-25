// Q 1 ) Given a number N, find the first N Fibonacci numbers. The first two number of the series are 1 and 1.
class Solution
{
    public static long fibbo(int n,long[] dp)
    {
        if(n<=1)
        {
            return 1;
        }
        
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        
        return  dp[n]=fibbo(n-1,dp) + fibbo(n-2,dp);
    }
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        long[] res=new long[n];
        long[] dp=new long[n];
        Arrays.fill(dp,-1);
        //Your code here
        for(int i=0;i<n;i++)
        {
            res[i]=fibbo(i,dp);
        }
        return res;
    }
}

// Q 2 ) 
/* Given an input stream A of n characters consisting only of lower case alphabets. While reading characters from the stream, you have to tell which character has appeared only once in the stream 
upto that point. If there are many characters that have appeared only once, you have to tell which one of them was the first one to appear. If there is no such character then append '#' to the 
answer.  */

class Solution
{
    public String first(String s)
    {
        HashMap<Character ,Integer> map=new HashMap<>();
        List<Character> list=new ArrayList<>();
        StringBuffer sb=new StringBuffer();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(!map.containsKey(c))
            {
                 map.put(c,1);
                 list.add(c);
            }
            
            else
            {
                int index=list.indexOf(c);
                if(index!=-1)
                {
                    list.remove(index);
                }
            }
            // list.size() > 0  ? sb.append(list.get(0)) : sb.append('#');
            sb.append(list.size()==0 ? '#' : list.get(0));
        
        }
        return sb.toString();
    }
    public String FirstNonRepeating(String A)
    {
        
        // code here
          return first(A);
    }
}





/*
Problem statement
You are given two strings 'STR1' and 'STR2'. You need to tell whether the strings are meta strings or not.

Meta strings are strings that can be made equal by swapping exactly one pair of distinct characters in one of the strings.

Note:
Equal strings are not considered as meta strings. 
  */
public class Solution{
    public static boolean check(String s1,String s2)
    {
        if(s1.equals(s2)) return false;
        HashMap<Integer,Character> map1=new HashMap<>();
        HashMap<Integer,Character> map2=new HashMap<>();
        int m=s1.length(),n=s2.length();
        int len=Math.min(m,n);
        int i;
        for( i=0;i<len;i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
             map1.put(i,s1.charAt(i));
             map2.put(i,s2.charAt(i));
            }
        }
        while(i<m)
        {
            map1.put(i,s1.charAt(i));
            i++;
        }
        while(i<n)
        {
            map2.put(i,s2.charAt(i));
            i++;
        }
        // System.out.println(map1.size());
        // System.out.println(map2.size());
        if(map1.isEmpty() && map2.isEmpty()) return true;
        if( map1.size()==1 || map2.size()==1) return false;
        if(map1.size()>2 || map2.size()>2) return false;
        if(map1.size()==2 && map2.size()==2) 
        {
           
            StringBuffer sb1=new StringBuffer();
            StringBuffer sb2=new StringBuffer();
            for(Map.Entry<Integer,Character> entry1:map1.entrySet())
            {
                
                sb1.append(entry1.getValue());
            }
             for(Map.Entry<Integer,Character> entry2:map2.entrySet())
            {
               
                 sb2.append(entry2.getValue());
            }
            if(sb1.length()==0 && sb2.length()==0) return true;
            if(sb2.reverse().toString().equals(sb1.toString()))
            {
                return true;
            }
            
            else return false;
        }
        return false;

    }
    public static boolean checkMeta(String str1, String str2) {
        // Write your code here.
       return  check(str1,str2);
    }
}

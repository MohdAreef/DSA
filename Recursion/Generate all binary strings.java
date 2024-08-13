// Given an integer N , Print all binary strings of size N which do not contain consecutive 1s.

// A binary string is that string which contains only 0 and 1.

class Solution {
    public static void generate(int index,int prev,int n,StringBuffer sb,List<String> res)
    {
        if(index==n)
        {
            res.add(sb.toString());
            return ;
        }
        
        //explore
        if(prev==0 || prev==2)
        {
             sb.append("0");
             generate(index+1,0,n,sb,res);
             sb.deleteCharAt(sb.length()-1);
            // sb=sb.substring(0,sb.length)
             sb.append("1");
            generate(index+1,1,n,sb,res);
             sb.deleteCharAt(sb.length()-1);
        }
        else if(prev==1)
        {
            sb.append("0");
            generate(index+1,0,n,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
       
    }
  public static List<String> generateBinaryStrings(int n) {
    // code here
    
    StringBuffer sb=new StringBuffer();
    List<String> res=new ArrayList<>();
    generate(0,2,n,sb,res);
    
    return res;

  }
}
     
     

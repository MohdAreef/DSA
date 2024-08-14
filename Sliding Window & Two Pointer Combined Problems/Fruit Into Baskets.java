/*
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array of arr[], 
where arr[i]  is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow :

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked 
fruits must fit in one of the baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array of fruits, return the maximum number of fruits you can pick.
*/

class Solution {
    public static int total(Integer[] arr)
    {
        int n=arr.length;
        int l=0,r=1;
        int maxi=Integer.MIN_VALUE;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(arr[0],1);
        while(l<r && r<n)
        {
            
            if(map.containsKey(arr[r]))
            {
                map.put(arr[r],map.get(arr[r])+1);
            }
            else 
            {
                map.put(arr[r],1);
            }
            
            while(map.size()>2)
            {
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0)
                {
                    map.remove(arr[l]);
                }
                l++;
            }
          
                r++;
            
            int sum=0;
            if(map.size()==2)
            {
                
            for(Map.Entry<Integer,Integer> entry: map.entrySet())
            {
                sum+=entry.getValue();
            }
            maxi=Math.max(maxi,sum);
            }
        }
        if(maxi==Integer.MIN_VALUE)
        {
            return 1;
        }
        return maxi;
    }
    public static int totalFruits(Integer[] arr) {
        // code here
        return total(arr);
    }
}

//POD 
/*
Difficulty: MediumAccuracy: 44.93%Submissions: 60K+Points: 4
Given an array of integers arr, sort the array according to the frequency of elements, i.e. elements that have higher frequency comes first. 
If the frequencies of two elements are the same, then the smaller number comes first.

Examples :

Input: arr[] = [5, 5, 4, 6, 4]
Output: [4, 4, 5, 5, 6]
Explanation: The highest frequency here is 2. Both 5 and 4 have that frequency. Now since the frequencies are the same the smaller element comes first. 
So 4 4 comes first then comes 5 5. Finally comes 6. The output is 4 4 5 5 6.
*/

class Pair
{
    int key,freq;
    Pair(int key,int freq)
    {
        this.key=key;
        this.freq=freq;
    }
}

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sort(int[] arr)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i]))
            {
                map.put(arr[i],map.get(arr[i])+1);
            }
            else
            {
                map.put(arr[i],1);
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->
        {
            if(a.freq==b.freq)
            {
                return Integer.compare(a.key,b.key);
            }
            else
            {
                return Integer.compare(b.freq,a.freq);
            }
        });
          
            for(Map.Entry<Integer,Integer> entry: map.entrySet())
            {
                
                pq.add(new Pair(entry.getKey(),entry.getValue()));
            }
        
        while(!pq.isEmpty())
        {
            Pair curr=pq.poll();
            for(int i=0;i<curr.freq;i++)
            {
                res.add(curr.key);
            }
            
        }
        return res;
      
      
    }
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        return sort(arr);
    }
}

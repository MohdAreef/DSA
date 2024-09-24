/*
Given an unsorted array arr of of positive integers. One number 'A' from set {1, 2,....,n} is missing and one number 'B' occurs twice in array. 
Find numbers A and B.
Examples
Input: arr[] = [2, 2]
Output: 2 1
Explanation: Repeating number is 2 and smallest positive missing number is 1.
Input: arr[] = [1, 3, 3] 
Output: 3 2
Explanation: Repeating number is 3 and smallest positive missing number is 2.
*/

class Solve {
    int[] find(int[] arr)
    {
        int xor=0;
        for(int i=0;i<arr.length;i++)
        {
            xor=xor^arr[i]^(i+1);
        }
    int temp=xor^(xor-1);
    temp=temp&xor;
    // System.out.println(xor+ " "+temp);
    int a=0,b=0;
    for(int i=0;i<arr.length;i++)
    {
        if(((i+1)&temp)==temp) 
        {
            a=a^(i+1);
        }
        else b=b^(i+1);
        
        if((arr[i]&temp)==temp)
        {
            a=a^arr[i];
        }
        else
        b=b^arr[i];
    }
    for(int i=0;i<arr.length;i++)
    {
        if(arr[i]==a)
        {
            return new int[]{a,b};
        }
    }    
    return new int[]{b,a};
    }
    int[] findTwoElement(int arr[]) {
        // code here
        return find(arr);
    }
}

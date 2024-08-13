//Given an integer n, find the square root of n. If n is not a perfect square, then return the floor value.

// Floor value of any number is the greatest Integer which is less than or equal to that number


class Solution {
    long floor(long n)
    {
        long l=0,h=n,mid=0;
        while(l<=h)
        {
             mid=l-(l-h)/2;
            if(mid*mid==n)
            {
                return mid;
            }
            
            if(mid*mid>n)
            {
                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return l-1;
    }
    long floorSqrt(long n) {
        // Your code here
        return floor(n);
    }
}

/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations 
of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that 
follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in 
ascending order).
*/
class Solution {
    public void next(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        boolean flag = false;
        while (i >= 0) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    int a = i + 1, b = n - 1;
                    System.out.println(Arrays.toString(nums));
                    flag = true;
                    while (a < b) {
                        int t = nums[a];
                        nums[a] = nums[b];
                        nums[b] = t;
                        a++;
                        b--;
                    }

                }

                if (flag == true)
                    break;
            }
            if (flag == true)
                break;
            i--;
        }
        if (flag == false) {
            Arrays.sort(nums);
        }

    }

    public void nextPermutation(int[] nums) {
        next(nums);

    }
}

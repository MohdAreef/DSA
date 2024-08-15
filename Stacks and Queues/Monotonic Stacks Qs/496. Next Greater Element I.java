/*
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. 
If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
*/

class Solution {
    public int[] nextgreater(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int i = nums2.length - 1;
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] nextgre = new int[nums2.length];
        for (int j = 0; j < nums1.length; j++) {
            map.put(nums1[j], j);
        }
        while (i >= 0) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nextgre[i] = -1;
            } else {
                nextgre[i] = stack.peek();
            }
            stack.push(nums2[i]);

            if (map.containsKey(nums2[i])) {
                res[map.get(nums2[i])] = nextgre[i];
            }
            i--;

        }
        return res;

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return nextgreater(nums1, nums2);
    }
}

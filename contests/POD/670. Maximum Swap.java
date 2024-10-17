/*
You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.

Example 1:

Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:

Input: num = 9973
Output: 9973
Explanation: No swap.
*/

// USING SELECTION SORT ALGORITHM

class Solution {
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        int a = num;
        while (a != 0) {
            list.add(0, a % 10);
            a = a / 10;
        }
        System.out.println(list.toString());
        int n = list.size();
        for (int i = 0; i < n; i++) {
            int index = i;
            int maxi = list.get(i);
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) >= maxi) {
                    maxi = list.get(j);
                    index = j;
                }
            }
            if (index != i && list.get(index) != list.get(i)) {
                int temp = list.get(index);
                list.set(index, list.get(i));
                list.set(i, temp);
                break;
            }
        }
        System.out.println(list.toString());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans * 10 + list.get(i);
        }
        return ans;

    }
}

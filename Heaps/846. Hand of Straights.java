/*
Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
*/


class Solution {
    public boolean check(int[] hand, int size) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) == 1) {
                pq.add(i);
            }
        }

        boolean flag = false;
        while (!map.isEmpty() && map.size() >= size) {
            int start = pq.peek();
            for (int i = 0; i < size; i++) {
                if (map.containsKey(start)) {
                    map.put(start, map.get(start) - 1);
                } else {
                    flag = true;
                    return false;
                }
                if (map.get(start) == 0) {
                    map.remove(start);
                    pq.remove(start);
                }
                start++;
            }
        }
        if (map.size() == 0)
            return true;
        else
            return false;

    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        return check(hand, groupSize);
    }
}

/*
You are given the string croakOfFrogs, which represents a combination of the string "croak" from different frogs, that is, multiple frogs can croak at the 
same time, so multiple "croak" are mixed.
Return the minimum number of different frogs to finish all the croaks in the given string.

A valid "croak" means a frog is printing five letters 'c', 'r', 'o', 'a', and 'k' sequentially. The frogs have to print all five letters to finish a croak. 
If the given string is not a combination of a valid "croak" return -1.

Example 1:

Input: croakOfFrogs = "croakcroak"
Output: 1 
Explanation: One frog yelling "croak" twice.
*/

class Solution {
    public int mintracks(List<int[]> list) {
        int n = list.size();

        int[] arrival = new int[n];
        int[] departure = new int[n];
        for (int i = 0; i < n; i++) {
            arrival[i] = list.get(i)[0];
            departure[i] = list.get(i)[1];

        }

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int l = 0, r = 0, maxi = 0, cnt = 0;
        while (l < n && r < n) {
            if (arrival[l] < departure[r]) {
                cnt++;
                l++;
            } else {
                cnt--;
                r++;
            }
            maxi = Math.max(maxi, cnt);
        }

        return maxi;

    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        int n = croakOfFrogs.length();
        if (n % 5 != 0)
            return -1;

        map.put('c', 0);
        map.put('r', 0);
        map.put('o', 0);
        map.put('a', 0);
        map.put('k', 0);
        int freq = 0;
        for (int i = 0; i < n; i++) {
            char c = croakOfFrogs.charAt(i);
            map.put(c, map.get(c) + 1);
            freq = map.get(c);
            if (c == 'c') {
                list.add(new int[] { i, 0 });
            } else if (c == 'k') {

                if (map.get('c') < freq || map.get('r') < freq || map.get('o') < freq || map.get('a') < freq)
                    return -1;

                list.get(map.get(c) - 1)[1] = i;
            } else if (c == 'r') {

                if (map.get('c') < freq) {
                    return -1;
                }
            }

            else if (c == 'o') {

                if (map.get('c') < freq || map.get('r') < freq)
                    return -1;
            } else if (c == 'a') {

                if (map.get('c') < freq || map.get('r') < freq || map.get('o') < freq)
                    return -1;
            }

        }

        freq = map.get('c');
        if (map.get('r') != freq || map.get('o') != freq || map.get('a') != freq || map.get('k') != freq)
            return -1;

        int ans = mintracks(list);
        if (ans == 0)
            return -1;

        return ans;

    }
}

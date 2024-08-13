/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any 
order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
*/

class Solution {
    public void generate(int index, String digits, List<String> res, String temp,
            HashMap<Integer, List<Character>> map) {
        // base condition
        if (index == digits.length()) {
            res.add(temp);
            return;
        }

        // explore
        int d = Character.getNumericValue(digits.charAt(index));
        for (Character i : map.get(d)) {
            generate(index + 1, digits, res, temp + i, map);
        }

    }

    public List<String> letterCombinations(String digits) {

        HashMap<Integer, List<Character>> map = new HashMap<>();
        map.put(2, new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put(3, new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put(4, new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put(5, new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put(6, new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put(7, new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put(8, new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put(9, new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        generate(0, digits, res, "", map);

        return res;

    }
}

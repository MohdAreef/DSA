class Solution {
    public int roman(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            String sub1 = s.substring(i, i + 1);
            // System.out.println(map.get())
            String sub2 = "";
            if ((i + 1) < s.length()) {
                sub2 = s.substring(i, i + 2);
            }
            if (map.containsKey(sub2)) {
                sum += map.get(sub2);
                i = i + 2;
            } else {
                sum += map.get(sub1);
                i++;
            }
            System.out.println(sum);
        }
        return sum;
    }

    public int romanToInt(String s) {
        return roman(s);
    }
}

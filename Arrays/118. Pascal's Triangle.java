/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
*/
class Solution {
    public List<List<Integer>> generatepascal(int numrows) {
        int i;
        List<List<Integer>> list = new ArrayList<>();
        for (i = 0; i < numrows; i++) {
            list.add(new ArrayList<Integer>());
        }
        list.get(0).add(1);
        for (i = 1; i < numrows; i++) {
            for (int j = 0; j <= i; j++) {
                int sum = 0;
                if (j > 0) {
                    sum += list.get(i - 1).get(j - 1);
                }
                if ((j) < list.get(i - 1).size()) {
                    sum += list.get(i - 1).get(j);
                }
                list.get(i).add(sum);
            }
        }
        return list;
    }

    public List<List<Integer>> generate(int numRows) {
        return generatepascal(numRows);
    }
}

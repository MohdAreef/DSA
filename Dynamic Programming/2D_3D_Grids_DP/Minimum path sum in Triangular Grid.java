// TABULATION SOLUTION
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            dp.add(new ArrayList<Integer>());
        }
        dp.get(0).add(triangle.get(0).get(0));
        int n = triangle.size();
        for (int level = 1; level < n; level++) {
            for (int index = 0; index < triangle.get(level).size(); index++) {

                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if ((index - 1) >= 0)
                    left = triangle.get(level).get(index) + dp.get(level - 1).get(index - 1);

                if (index < triangle.get(level - 1).size())
                    right = triangle.get(level).get(index) + dp.get(level - 1).get(index);

                dp.get(level).add(Math.min(left, right));

            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < dp.get(n - 1).size(); i++) {
            ans = Math.min(ans, dp.get(n - 1).get(i));
        }
        return ans;

    }
}
// SPACE OPTIMIZATION
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        List<Integer> prev = new ArrayList<>();
        prev.add(triangle.get(0).get(0));

        int n = triangle.size();

        for (int level = 1; level < n; level++) {
            List<Integer> curr = new ArrayList<>();
            for (int index = 0; index < triangle.get(level).size(); index++) {

                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if ((index - 1) >= 0)
                    left = triangle.get(level).get(index) + prev.get(index - 1);

                if (index < triangle.get(level - 1).size())
                    right = triangle.get(level).get(index) + prev.get(index);

                curr.add(Math.min(left, right));

            }
            prev = curr;
            curr = null;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < prev.size(); i++) {
            ans = Math.min(ans, prev.get(i));
        }
        return ans;

    }
}

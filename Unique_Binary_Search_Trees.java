/* Dynamic programming solution with time complexity O(n^2) and space complexity O(n).*/
class Solution {
    public int numTrees(int n) {
        HashMap<Integer, Integer> ways = new HashMap<Integer, Integer>();
        ways.put(0,1);
        ways.put(1,1);
        ways.put(2,2);
        if (n > 2) {
            for (int i = 3; i <= n; i++) {
                int w = 0;
                for (int j = 1; j <= i; j++) {
                    int left = j - 1;
                    int right = i - j;
                    w += ways.get(left) * ways.get(right);
                }
                ways.put(i, w);
            }
        }
        return ways.get(n);
    }
}

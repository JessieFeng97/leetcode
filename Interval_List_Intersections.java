class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int pt1 = 0;
        int pt2 = 0;
        int start = -1;
        int end = start;
        int t1 = 0;
        int t2 = 0;
        
        ArrayList<int[]> res = new ArrayList();
        
        while (pt1 < A.length || pt2 < B.length) {
            if (((pt1 < A.length && pt2 < B.length) && (A[pt1][0] <= B[pt2][0])) || (pt1 < A.length && pt2 == B.length)){
                t1 = A[pt1][0];
                t2 = A[pt1][1];
                pt1++;
            } else {
                t1 = B[pt2][0];
                t2 = B[pt2][1];
                pt2++;
            }
            if (start == -1) {
                start = t1;
                end = t2;
            } else if (t1 <= end) {
                int[] inter = new int[2];
                inter[0] = t1;
                inter[1] = Math.min(end, t2);
                end = Math.max(end, t2);
                start = t1;
                res.add(inter);
            } else {
                start = t1;
                end = t2;
            }
        }
        
        int[][] result = new int[res.size()][2];
        int i = 0;
        for (int[] c: res) {
            result[i] = c;
            i++;
        }
        return result;
    }
}

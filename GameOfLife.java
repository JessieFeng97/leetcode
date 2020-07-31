class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int[] counts = new int[board.length * board[0].length];
        int index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                counts[index] = findlivenb(board, i, j);
                index++;
            }
        }
        
        index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int c = counts[index];
                index++;
                if (c < 2) board[i][j] = 0;
                else if ((c == 2 || c == 3) && board[i][j] == 1) board[i][j] = 1;
                else if (c == 3 && board[i][j] == 0) board[i][j] = 1;
                else if (c > 3) board[i][j] = 0;
            }
        }
        return;
    }
    
    private int findlivenb(int[][] board, int m, int n) {
        int[] dir = new int[]{1, 0, -1, 0, 1, 1, -1, -1};
        int[] dic = new int[]{0, 1, 0, -1, 1, -1, -1, 1};
        
        int x;
        int y;
        int count = 0;
        for (int i = 0; i < 8; i++) {
            x = m + dir[i];
            y = n + dic[i];
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                continue;
            } else {
                if (board[x][y] == 1) count++;
            }
        }
        return count;
    }
}

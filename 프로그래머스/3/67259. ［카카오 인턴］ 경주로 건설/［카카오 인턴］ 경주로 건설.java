import java.util.*;

class Solution {
    static final int DIRECT = 100;
    static final int CORNER = 500;
    int length;
    int[][] board;
    int[][][] dp;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] board) {
        this.board = board;
        this.length = board.length;
        dp = new int[length][length][4];
        for (int i=0; i<length; i++) {
            for (int j=0; j<length; j++) {
                for (int k=0; k<4; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;   
                }
            }
        }
        Queue<Point> queue = new LinkedList<>();
        if (board[1][0] == 0) {
            queue.add(new Point(0, 1, 100, 0, 1));
            for (int i=0; i<4; i++) dp[1][0][i] = 100;
        }
        if (board[0][1] == 0) {
            queue.add(new Point(1, 0, 100, 1, 0));
            for (int i=0; i<4; i++) dp[0][1][i] = 100;
        }
        
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            
            for (int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (outOfArray(nx, ny)) continue;
                int ns = p.s + DIRECT;
                if (p.px != dx[i] || p.py != dy[i]) ns += CORNER;
                
                if (dp[ny][nx][i] > ns && board[ny][nx] == 0) {
                    dp[ny][nx][i] = ns;
                    queue.add(new Point(nx, ny, ns, dx[i], dy[i]));
                }
            }
        }
        
        
        return Math.min(dp[length-1][length-1][0], dp[length-1][length-1][1]);
    }
    
    private boolean outOfArray(int x, int y) {
        return x<0 || x>=length || y<0 || y>=length;
    }
    
    class Point {
        int y,x,s,py,px;
        public Point(int x, int y, int s, int px, int py) {
            this.y = y;
            this.x = x;
            this.s = s;
            this.py = py;
            this.px = px;
        }
    }
}
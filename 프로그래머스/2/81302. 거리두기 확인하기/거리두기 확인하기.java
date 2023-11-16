class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    int[] answer = new int[5];
    boolean[][] visited;
    char[][] cplace;
    int index = 0;
    
    public int[] solution(String[][] places) {
        for (int i=0; i<5; i++) {
            answer[i] = 1;
        }
        
        for (int i=0; i<5; i++) {
            cplace = new char[5][5];
            visited = new boolean[5][5];
            for (int j=0; j<5; j++) {
                cplace[j] = places[i][j].toCharArray();
            }
            
            for(int j=0; j<5; j++) {
                for (int k=0; k<5; k++) {
                    if (cplace[j][k] == 'P') {
                        visited[j][k] = true;
                        dfs(j, k, 0);
                        visited[j][k] = false;
                    }
                }
            }
            index++;
        }
        return answer;
    }
    
    private void dfs(int y, int x, int count) {
        if (count > 0 && cplace[y][x] == 'P') {
            answer[index] = 0;
            return;
        } else if (count == 2) {
            return;
        }
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!outOfArray(ny, nx)) {
                if (!visited[ny][nx] && cplace[ny][nx] != 'X') {
                    visited[ny][nx] = true;
                    dfs(ny, nx, count+1);
                    visited[ny][nx] = false;
                }
            }
        }
    }
    
    private boolean outOfArray(int y, int x) {
        return x<0 || x>4 || y<0 || y>4;
    }
}
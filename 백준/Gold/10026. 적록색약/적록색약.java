import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int result1, result2;
    static char[][] painting;
    static boolean[][][] visited;
    static Queue<int[]> queue1;
    static Queue<int[]> queue2;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        painting = new char[N][N];
        for (int i = 0; i < N; i++) {
            painting[i] = br.readLine().toCharArray();
        }

        visited = new boolean[2][N][N];
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (!visited[0][y][x]) {
                    queue1.add(new int[] {x, y});
                    visited[0][y][x] = true;
                    probing1();
                }
                if (!visited[1][y][x]) {
                    queue2.add(new int[] {x, y});
                    visited[1][y][x] = true;
                    probing2();
                }
            }
        }

        System.out.println(result1 + " " + result2);
    }

    private static void probing1() {
        while (!queue1.isEmpty()) {
            int[] point = queue1.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dir[i][0];
                int ny = point[1] + dir[i][1];
                if (!outOfRange(nx, ny) && !visited[0][ny][nx] && isSameColor1(point[0], point[1], nx, ny)) {
                    queue1.add(new int[] {nx, ny});
                    visited[0][ny][nx] = true;
                }
            }
        }
        result1++;
    }

    private static void probing2() {
        while (!queue2.isEmpty()) {
            int[] point = queue2.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dir[i][0];
                int ny = point[1] + dir[i][1];
                if (!outOfRange(nx, ny) && !visited[1][ny][nx] && isSameColor2(point[0], point[1], nx, ny)) {
                    queue2.add(new int[] {nx, ny});
                    visited[1][ny][nx] = true;
                }
            }
        }
        result2++;
    }

    private static boolean isSameColor2(int x, int y, int nx, int ny) {
        if (painting[y][x] == painting[ny][nx]) {
            return true;
        } else if (painting[y][x] == 'R' && painting[ny][nx] == 'G') {
            return true;
        } else if (painting[y][x] == 'G' && painting[ny][nx] == 'R') {
            return true;
        }
        return false;
    }

    private static boolean isSameColor1(int x, int y, int nx, int ny) {
        return painting[y][x] == painting[ny][nx];
    }

    private static boolean outOfRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }
}

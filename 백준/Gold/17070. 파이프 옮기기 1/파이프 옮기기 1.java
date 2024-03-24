import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(new int[]{0, 0}, new int[]{0, 1});
        System.out.println(result);
    }

    private static void dfs(int[] p1, int[] p2) {
        if (p2[0] == N-1 && p2[1] == N-1) {
            result++;
            return;
        }

        if (p1[1] == p2[1]) {
            if (p2[0] < N - 1 && arr[p2[0] + 1][p2[1]] == 0) {
                dfs(new int[]{p1[0] + 1, p1[1]}, new int[]{p2[0] + 1, p2[1]});
            }
            if (p2[0] < N - 1 && p2[1] < N - 1 &&arr[p2[0] + 1][p2[1]] == 0 && arr[p2[0]][p2[1] + 1] == 0 && arr[p2[0] + 1][p2[1] + 1] == 0) {
                dfs(new int[]{p1[0] + 1, p1[1]}, new int[]{p2[0] + 1, p2[1] + 1});
            }
        } else if (p1[0] == p2[0]) {
            if (p2[1] < N - 1 && arr[p2[0]][p2[1] + 1] == 0) {
                dfs(new int[]{p1[0], p1[1] + 1}, new int[]{p2[0], p2[1] + 1});
            }
            if (p2[0] < N - 1 && p2[1] < N - 1 && arr[p2[0]][p2[1] + 1] == 0 && arr[p2[0] + 1][p2[1]] == 0 && arr[p2[0] + 1][p2[1] + 1] == 0) {
                dfs(new int[]{p1[0], p1[1] + 1}, new int[]{p2[0] + 1, p2[1] + 1});
            }
        } else {
            if (p2[1] < N - 1 && arr[p2[0]][p2[1] + 1] == 0) {
                dfs(new int[]{p1[0] + 1, p1[1] + 1}, new int[]{p2[0], p2[1] + 1});
            }
            if (p2[0] < N - 1 && arr[p2[0] + 1][p2[1]] == 0) {
                dfs(new int[]{p1[0] + 1, p1[1] + 1}, new int[]{p2[0] + 1, p2[1]});
            }
            if (p2[0] < N - 1 && p2[1] < N - 1 && arr[p2[0] + 1][p2[1]] == 0 && arr[p2[0]][p2[1] + 1] == 0 && arr[p2[0] + 1][p2[1] + 1] == 0) {
                dfs(new int[]{p1[0] + 1, p1[1] + 1}, new int[]{p2[0] + 1, p2[1] + 1});
            }
        }
    }
}

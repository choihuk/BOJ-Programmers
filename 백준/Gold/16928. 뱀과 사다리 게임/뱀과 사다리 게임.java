import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] ladder;
    static int[] snake;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        ladder = new int[101];
        snake = new int[101];
        memo = new int[101];
        for (int i = 0; i < N; i++) {
            String[] s1 = br.readLine().split(" ");
            ladder[Integer.parseInt(s1[0])] = Integer.parseInt(s1[1]);
        }
        for (int i = 0; i < M; i++) {
            String[] s1 = br.readLine().split(" ");
            snake[Integer.parseInt(s1[0])] = Integer.parseInt(s1[1]);
        }
        for (int i = 0; i < 101; i++) {
            memo[i] = 999_999_999;
        }

        dfs(1, 0);
        System.out.println(memo[100]);
    }

    private static void dfs(int room, int count) {
        memo[room] = count;
        for (int i = 6; i > 0; i--) {
            int nextRoom = room + i;
            if (nextRoom > 100) {
                memo[100] = Math.min(memo[100], count + 1);
                return;
            }

            if (ladder[nextRoom] != 0) {
                nextRoom = ladder[nextRoom];
            } else if (snake[nextRoom] != 0) {
                nextRoom = snake[nextRoom];
            }

            if (memo[nextRoom] > count + 1) {
                dfs(nextRoom, count + 1);
            }
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int N;
    private static int[][] circle;
    private static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        circle = new int[N][N];
        memo = new int[N][N];
        for (int i = 0; i< N; i++) {
            String[] numbers = br.readLine().split(" ");
            for (int j=0; j<numbers.length; j++) {
                circle[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        memo[0][0] = circle[0][0];

        dp(0, 0);

        System.out.println(Arrays.stream(memo[N - 1]).max().getAsInt());
    }

    private static void dp(int depth, int index) {
        if (depth >= N-1) return;

        int num = memo[depth][index];
        if (num + circle[depth+1][index] > memo[depth+1][index]) {
            memo[depth+1][index] = num + circle[depth+1][index];
            dp(depth+1, index);
        }
        if (num + circle[depth+1][index+1] > memo[depth+1][index+1]) {
            memo[depth+1][index+1] = num + circle[depth+1][index+1];
            dp(depth+1, index+1);
        }
    }
}

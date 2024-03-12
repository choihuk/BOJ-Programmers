import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[][] rgb;
    private static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        rgb = new int[N][3];
        memo = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] num = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(num[j]);
            }
        }

        memo[0][0] = rgb[0][0];
        memo[0][1] = rgb[0][1];
        memo[0][2] = rgb[0][2];
        
        System.out.println(Math.min(Math.min(dp(N-1, 0), dp(N-1, 1)), dp(N-1, 2)));

    }

    private static int dp(int depth, int color) {
        if(memo[depth][color] == 0) {
            if(color == 0) {
                memo[depth][0] = Math.min(dp(depth - 1, 1), dp(depth - 1, 2)) + rgb[depth][0];
            }
            else if(color == 1) {
                memo[depth][1] = Math.min(dp(depth - 1, 0), dp(depth - 1, 2)) + rgb[depth][1];
            }
            else {
                memo[depth][2] = Math.min(dp(depth - 1, 0), dp(depth - 1, 1)) + rgb[depth][2];
            }
        }
        return memo[depth][color];
    }
}

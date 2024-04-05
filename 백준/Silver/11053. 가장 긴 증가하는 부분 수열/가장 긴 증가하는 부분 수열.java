import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] A;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        memo = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dp(0, 0, 0);

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, memo[i]);
        }
        System.out.println(result);
    }

    private static void dp(int index, int last, int count) {
        if (index >= N) return;

        if (A[index] > last && memo[index] < count+1) {
            memo[index] = count+1;
            dp(index+1, A[index], count+1);
        }

        dp(index+1, last, count);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int op = Integer.parseInt(str[0]);
            int a = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);
            if (op == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        arr[find(a)] = find(b);
    }

    private static int find(int a) {
        if (arr[a] == a) {
            return a;
        } else {
            return arr[a] = find(arr[a]);
        }
    }
}

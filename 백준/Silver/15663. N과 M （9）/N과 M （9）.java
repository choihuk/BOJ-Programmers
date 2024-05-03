import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static List<Integer> nums;
    static List<Integer> list;
    static Set<String> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new ArrayList<>();
        list = new ArrayList<>();
        answer = new LinkedHashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        nums.sort(Integer::compareTo);

        dfs(0);
        StringBuilder sb = new StringBuilder();
        answer.forEach(s -> sb.append(s).append("\n"));
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(nums.get(list.get(i))).append(" ");
            }
            answer.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (list.contains(i)) continue;
            list.add(depth, i);
            dfs(depth+1);
            list.remove((int) depth);
        }
    }

}

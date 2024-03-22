import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int count = 0;
    static int fishSize = 2;
    static int eatSize = 0;
    static int[] shark = new int[2];
    static int[][] sea;
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sea = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 9) {
                    shark[1] = i;
                    shark[0] = j;
                } else {
                    sea[i][j] = num;
                }
            }
        }

        int result = findAndEatFish();
        while (result != 0) {
            count += result;
            eatSize++;
            if (eatSize == fishSize) {
                eatSize = 0;
                fishSize++;
            }
            result = findAndEatFish();
        }
        System.out.println(count);
    }

    private static int findAndEatFish() {
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        q1.add(shark);
        visited[shark[1]][shark[0]] = true;
        int[] target = null;
        int count = 1;
        do {
            while (!q1.isEmpty()) {
                int[] p = q1.poll();
                for (int i = 0; i < 4; i++) {
                    int[] np = {p[0] + dir[i][0], p[1] + dir[i][1]};
                    if (notOut(np) && notVisited(np)) {
                        if (sea[np[1]][np[0]] == fishSize || sea[np[1]][np[0]] == 0) {
                            q2.add(np);
                            visited[np[1]][np[0]] = true;
                        } else if (sea[np[1]][np[0]] < fishSize) {
                            if (target == null || target[1] > np[1] || (target[1] == np[1] && target[0] > np[0])) {
                                target = np;
                            }
                        }
                    }
                }
            }
            if (target != null) {
                shark = target;
                sea[target[1]][target[0]] = 0;
                visited = new boolean[N][N];
                return count;
            }
            q1 = q2;
            q2 = new LinkedList<>();
            count++;
        } while (!q1.isEmpty());

        return 0;
    }

    private static boolean notVisited(int[] np) {
        return !visited[np[1]][np[0]];
    }

    private static boolean notOut(int[] np) {
        return np[0] >= 0 && np[0] < N && np[1] >= 0 && np[1] < N;
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R;
    static int C;
    static int[] purifier;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        purifier = null;
        int[][] room = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1 && purifier == null) {
                    purifier = new int[]{i, j};
                }
            }
        }

        for (int t = 0; t < T; t++) {
            int[][] newRoom = createNewRoom();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (room[i][j] < 1) continue;
                    int dust = room[i][j] / 5;
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = j + dir[k][0];
                        int ny = i + dir[k][1];
                        if (!isOutOfArr(ny, nx) && room[ny][nx] != -1) {
                            newRoom[ny][nx] += dust;
                            count++;
                        }
                    }
                    newRoom[i][j] += room[i][j] - dust * count;
                }
            }
            room = newRoom;

            for (int i = purifier[0]-1; i > 0; i--) {
                room[i][0] = room[i-1][0];
            }
            for (int i = purifier[0]+2; i < R-1; i++) {
                room[i][0] = room[i+1][0];
            }

            for (int i = 0; i < C-1 ; i++) {
                room[0][i] = room[0][i+1];
                room[R-1][i] = room[R-1][i+1];
            }

            for (int i = 0; i < purifier[0]; i++) {
                room[i][C-1] = room[i+1][C-1];
            }
            for (int i = R-1; i > purifier[0]; i--) {
                room[i][C-1] = room[i-1][C-1];
            }

            for (int i = C-1; i > 1; i--) {
                room[purifier[0]][i] = room[purifier[0]][i-1];
                room[purifier[0]+1][i] = room[purifier[0]+1][i-1];
            }
            room[purifier[0]][1] = 0;
            room[purifier[0]+1][1] = 0;
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += room[i][j];
            }
        }

        System.out.println(sum + 2);
    }

    private static boolean isOutOfArr(int y, int x) {
        return x < 0 || x >= C || y < 0 || y >= R;
    }

    private static int[][] createNewRoom() {
        int[][] newRoom = new int[R][C];
        newRoom[purifier[0]][purifier[1]] = -1;
        newRoom[purifier[0]+1][purifier[1]] = -1;
        return newRoom;
    }

}

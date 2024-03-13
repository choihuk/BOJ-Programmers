import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt((s[1]));
        Map<Integer, String> numToStrMap = new HashMap<>();
        Map<String, Integer> strToNumMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            numToStrMap.put(i + 1, temp);
            strToNumMap.put(temp, i + 1);
        }
        for (int i = 0; i < M; i++) {
            String po = br.readLine();
            try {
                int poNum = Integer.parseInt(po);
                System.out.println(numToStrMap.get(poNum));
            } catch (NumberFormatException e) {
                System.out.println(strToNumMap.get(po));
            }
        }
    }
}

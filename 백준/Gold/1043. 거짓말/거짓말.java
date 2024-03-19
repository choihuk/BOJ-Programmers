import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> know;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        know = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(s[0]); i++) {
            know.add(Integer.parseInt(s[i + 1]));
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < Integer.parseInt(s[0]); j++) {
                set.add(Integer.parseInt(s[j + 1]));
            }
            map.put(i, set);
        }

        int index = 0;
        while (know.size() > index) {
            List<Integer> removeKey = new ArrayList<>();
            int finalIndex = index;
            map.forEach((i, group) -> {
                if (group.contains(know.get(finalIndex))) {
                    group.remove(know.get(finalIndex));
                    for (int person : group) {
                        if (!know.contains(person)) {
                            know.add(person);
                        }
                    }
                    if (group.size() == 0) {
                        removeKey.add(i);
                    }
                }
            });
            removeKey.forEach(map::remove);
            index++;
        }

        System.out.println(map.size());
    }

}

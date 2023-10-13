import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> temp = Arrays.stream(br.readLine().split(""))
                                     .collect(Collectors.toList());
        LinkedList<String> list = new LinkedList<>(temp);
        ListIterator<String> iterator = list.listIterator(temp.size());

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String token = st.nextToken();
            if (token.equals("L") && iterator.hasPrevious()) {
                iterator.previous();
            } else if (token.equals("D") && iterator.hasNext()) {
                iterator.next();
            } else if (token.equals("B") && iterator.hasPrevious()) {
                iterator.previous();
                iterator.remove();
            } else if (token.equals("P")){
                iterator.add(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String l : list) {
            sb.append(l);
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();
            String[] pArray = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            Deque<String> deque = new LinkedList<>();
            String temp = br.readLine();
            String[] x = temp.substring(1, temp.length() - 1).split(",");
            for (int j = 0; j < n; j++) {
                deque.addLast(x[j]);
            }

            boolean dir = true;
            boolean isError = false;
            for (String p : pArray) {
                if (p.equals("R")) {
                    dir = !dir;
                } else if (p.equals("D")) {
                    if (deque.isEmpty()) {
                        System.out.println("error");
                        isError = true;
                        break;
                    } else if (dir) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }
            if (isError) {
                continue;
            }
            sb.append("[");
            int size = deque.size();
            if (dir) {
                for (int j = 0; j < size; j++) {
                    sb.append(deque.removeFirst()).append(",");
                }
            } else {
                for (int j = 0; j < size; j++) {
                    sb.append(deque.removeLast()).append(",");
                }
            }
            if (size != 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
            sb.append("]");
            System.out.println(sb);
        }
    }
}

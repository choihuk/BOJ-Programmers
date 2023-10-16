import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int s = 1;
        stack.push(s++);
        sb.append("+\n");
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            while (true) {
                if (stack.isEmpty()) {
                    stack.push(s++);
                    sb.append("+\n");
                } else if (k > stack.peek()) {
                    stack.push(s++);
                    sb.append("+\n");
                } else if (k == stack.peek()) {
                    stack.pop();
                    sb.append("-\n");
                    break;
                } else {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}

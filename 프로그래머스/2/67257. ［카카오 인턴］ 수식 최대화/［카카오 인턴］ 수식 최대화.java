import java.util.*;

class Solution {
    
    String[][] operands = {
        {"+", "-", "*"},
        {"+", "*", "-"},
        {"-", "+", "*"},
        {"-", "*", "+"},
        {"*", "-", "+"},
        {"*", "+", "-"}
    };
    
    public long solution(String expression) {
        long answer = 0;
        
        for (String[] operand : operands) {
            int start = 0;
            Deque<String> deque = new LinkedList<>();
            char[] e = expression.toCharArray();
            for (int i=0; i<e.length; i++) {
                if (e[i] == '+' || e[i] == '-' || e[i] == '*') {
                    deque.addLast(expression.substring(start, i));
                    deque.addLast(expression.substring(i, i+1));
                    start = i+1;
                }
            }
            deque.addLast(expression.substring(start, expression.length()));
            
            for (String o : operand) {
                Deque<String> newDeque = new LinkedList<>();
                while (!deque.isEmpty()) {
                    String s = deque.pollFirst();
                    if (s.equals(o)) {
                        long result = calc(newDeque.pollLast(), deque.pollFirst(), o);
                        newDeque.addLast(Long.toString(result));
                    } else {
                        newDeque.addLast(s);
                    }
                }
                deque = newDeque;
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(deque.poll())));
        }
        
        return answer;
    }
    
    private long calc(String a, String b, String operand) {
        if (operand.equals("+")) {
            return Long.parseLong(a) + Long.parseLong(b);
        } else if (operand.equals("-")) {
            return Long.parseLong(a) - Long.parseLong(b);
        } else {
            return Long.parseLong(a) * Long.parseLong(b);
        }
    }
}
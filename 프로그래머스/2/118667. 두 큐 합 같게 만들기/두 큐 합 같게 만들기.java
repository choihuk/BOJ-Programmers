import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long s1 = 0L, s2 = 0L;
        for (int i=0; i<queue1.length; i++) {
            q1.add(queue1[i]);
            s1 += queue1[i];
            
            q2.add(queue2[i]);
            s2 += queue2[i];
        }
        
        int answer = 0;
        while (s1 != s2 && !q1.isEmpty() && !q2.isEmpty() && answer < queue1.length*4) {
            if (s1 > s2) {
                int num = q1.poll();
                s1 -= num;
                s2 += num;
                q2.add(num);
            } else {
                int num = q2.poll();
                s1 += num;
                s2 -= num;
                q1.add(num);
            }
            answer++;
        }
        
        return s1 == s2 ? answer : -1;
    }
}
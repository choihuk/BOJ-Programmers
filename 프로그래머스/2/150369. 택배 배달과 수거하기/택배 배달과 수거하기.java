import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> dstack = new Stack<>();
        Stack<Integer> pstack = new Stack<>();
        for (int i=0; i<n; i++) {
            if (deliveries[i] > 0) {
                dstack.push((i+1)*100 + deliveries[i]);
            }
            if (pickups[i] > 0) {
                pstack.push((i+1)*100 + pickups[i]);
            }
        }
        
        while (!dstack.empty() || !pstack.empty()) {
            int maxD = 0;
            int currentCap = cap;
            while (!dstack.empty() && currentCap > 0) {
                int num = dstack.pop();
                int tackbea = num%100;
                int d = num/100;
                while(tackbea > 0 && currentCap > 0) {
                    tackbea--;
                    currentCap--;
                }
                if (tackbea > 0 && currentCap == 0) {
                    dstack.push(d*100 + tackbea);
                }
                maxD = Math.max(maxD, d);
            }
            
            currentCap = 0;
            while (!pstack.empty() && currentCap < cap) {
                int num = pstack.pop();
                int tackbea = num%100;
                int d = num/100;
                while(tackbea > 0 && currentCap < cap) {
                    tackbea--;
                    currentCap++;
                }
                if (tackbea > 0 && currentCap == cap) {
                    pstack.push(d*100 + tackbea);
                }
                maxD = Math.max(maxD, d);
            }
            answer += maxD*2;
        }
        return answer;
    }
}
import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            termMap.put(t[0], Integer.parseInt(t[1]));
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= privacies.length; i++) {
            String[] p = privacies[i-1].split(" ");
            Date date = new Date(p[0]);
            if (!date.isOk(today, termMap.get(p[1]))) {
                list.add(i);
            }
        }
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    class Date {
        private int year;
        private int month;
        private int day;
        
        public Date(String date) {
            String[] d = date.split("\\.");
            this.year = Integer.parseInt(d[0]);
            this.month = Integer.parseInt(d[1]);
            this.day = Integer.parseInt(d[2]);
        }
        
        public boolean isOk(String today, int term) {
            int[] todayArr = Arrays.stream(today.split("\\."))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            int privacyYear = year + (term+month-1)/12;
            int privacyMonth = (term+month-1)%12 + 1;
            int privacyDay = day;
            if (todayArr[0] < privacyYear) {
                return true;
            } else if (todayArr[0] == privacyYear && todayArr[1] < privacyMonth) {
                return true;
            } else if (todayArr[0] == privacyYear && todayArr[1] == privacyMonth && todayArr[2] < privacyDay) {
                return true;
            }
            return false;
        }
    }
}
import java.util.*;

class Solution {
    String[] personality = {"R", "T", "C", "F", "J", "M", "A", "N"};
    
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> map = new HashMap<>();
        for (String p : personality) map.put(p, 0);
        
        for (int i=0; i<survey.length; i++) {
            if (choices[i] > 4) {
                String p = survey[i].substring(1, 2);
                map.put(p, map.get(p) + choices[i] - 4);    
            } else if (choices[i] < 4) {
                String p = survey[i].substring(0, 1);
                map.put(p, map.get(p) + 4 - choices[i]);    
            }
        }
        
        String answer = "";
        for (int i=0; i<personality.length; i+=2) {
            int a = map.get(personality[i]);
            int b = map.get(personality[i+1]);
            if (a >= b) {
                answer += personality[i];
            } else {
                answer += personality[i+1];
            }
        }
        
        return answer;
    }
}
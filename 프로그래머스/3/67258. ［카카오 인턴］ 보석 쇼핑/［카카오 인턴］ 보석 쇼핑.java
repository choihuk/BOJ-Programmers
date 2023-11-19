import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[]{1, gems.length};
        Set<String> set = new HashSet<>();
        for (String gem : gems) set.add(gem);
        int length = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        for (int i=0; i<gems.length; i++) {
            map.compute(gems[i], (g, v) -> v==null ? 1 : v+1);
            if (map.size() == length) {
                while (map.get(gems[start]) != 1) {
                    map.compute(gems[start++], (g, v) -> v-1);
                }
                if (answer[1]-answer[0] > i-start) {
                    answer = new int[]{start+1 , i+1};
                }
            }
        }
        
        return answer;
    }
}
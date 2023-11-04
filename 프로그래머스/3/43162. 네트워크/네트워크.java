import java.util.*;

class Solution {
    private Set<Integer> set = new HashSet<>();
    private int n;
    private int[][] computers;
    public int solution(int n, int[][] computers) {
        int result = 0;
        this.n = n;
        this.computers = computers;
        for (int i=0; i<n; i++) {
            if (!set.contains(i)) {
                dfs(i);
                result++;
            }
        }
        return result;
    }
    
    private void dfs(int num) {
        set.add(num);
        for(int i=0; i<n; i++) {
            if (!set.contains(i) && computers[num][i] == 1) {
                dfs(i);
            }
        }
    }
}
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cs = 1;
        int i = 0;
        while(i < stations.length) {
            if (cs < stations[i]-w) {
                answer++;
                cs = cs + w*2 + 1;
            } else {
                cs = stations[i++] + w + 1;
            }
        }
        while(cs <= n) {
            cs = cs + w*2 + 1;
            answer++;
        }
        return answer;
    }
}
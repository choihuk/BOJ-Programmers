class Solution {
    int[][] dp = new int[152][152];
    
    public int solution(int alp, int cop, int[][] problems) {
        int galp=0, gcop=0;
        for (int[] problem : problems) {
            galp = Math.max(galp, problem[0]);
            gcop = Math.max(gcop, problem[1]);
        }
        alp = Math.min(alp, galp);
        cop = Math.min(cop, gcop);
        for (int i=0; i<152; i++) {
            for (int j=0; j<152; j++) {
                dp[i][j] = 99999;
            }
        }
        dp[alp][cop] = 0;
        
        for (int i=alp; i<=galp; i++) {
            for (int j=cop; j<=gcop; j++) {
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);
                for(int[] problem : problems) {
                    if (problem[0] > i || problem[1] > j) continue;
                    int nextAlp = Math.min(galp, i+problem[2]);
                    int nextCop = Math.min(gcop, j+problem[3]);
                    dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], 
                                                   dp[i][j] + problem[4]);
                }
            }
        }
        
        return dp[galp][gcop];
    }
}
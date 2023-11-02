class Solution {
    private int[] cookie;
    private int len;
    public int solution(int[] cookie) {
        this.cookie = cookie;
        len = cookie.length;
        int answer = 0;
        for(int m=1; m<len; m++) {
            int sum = chooseCookies(m);
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    
    public int chooseCookies(int m) {
        int l = m-1;
        int r = m;
        int lsum = 0;
        int rsum = 0;
        int max = 0;
        do {
            if (lsum > rsum) {
                if(r >= len) {
                    for(int i=l; i>=0; i--) {
                        lsum += cookie[i];
                        if (lsum == rsum) {
                            max = Math.max(lsum, max);
                        }
                    }
                    break;
                }
                rsum += cookie[r++];
            } else if(lsum < rsum) {
                if(l < 0) {
                    for(int i=r; i<len; i++) {
                        rsum += cookie[i];
                        if (lsum == rsum) {
                            max = Math.max(lsum, max);
                        }
                    }
                    break;
                }
                lsum += cookie[l--];
            }
            if (lsum == rsum) {
                max = Math.max(lsum, max);
                if (r < len) {
                    rsum += cookie[r++];
                } else {
                    break;
                }
            } 
        } while(l >= -1 && r <= len);
        return max;
    }
}
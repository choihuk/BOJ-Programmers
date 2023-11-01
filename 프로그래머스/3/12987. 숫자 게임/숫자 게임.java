import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int length = B.length;
        int bi = 0;
        for(int a : A) {
            for(; bi < length; bi++) {
                if (B[bi] > a) {
                    B[bi] = 0;
                    break;
                }
            }
        }
        
        int count = 0;
        for(int b : B) {
            if (b == 0)
                count++;
        }
        return count;
    }
}
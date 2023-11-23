class Solution {
    int[] answer;
    public int[] solution(long[] numbers) {
        answer = new int[numbers.length];
        
        for (int i=0; i<numbers.length; i++) {
            String s = Long.toBinaryString(numbers[i]);
            int treeLength = 0;
            for (int j=0; treeLength<100; j++) {
                treeLength += Math.pow(2, j);
                if (treeLength < s.length()) continue;
                
                int plus = treeLength - s.length();
                StringBuilder sb = new StringBuilder();
                while (plus --> 0) sb.append("0");
                s = sb.toString() + s;
                
                boolean isFull = true;
                for (int k=1; k<=treeLength; k++) {
                    if (s.charAt(k-1) == '0') continue;
                    int p = j;
                    int idx = (int) Math.pow(2, p);
                    do {
                        if (s.charAt(idx-1) == '0') {
                            isFull = false;
                        }
                        if (idx > k) {
                            idx -= (int) Math.pow(2, --p);
                        } else if (idx < k) {
                            idx += (int) Math.pow(2, --p);
                        }
                    } while (idx != k && isFull);
                }
                if (isFull) answer[i] = 1;
            }
        }
        
        return answer;
    }
    
}
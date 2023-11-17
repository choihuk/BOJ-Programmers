class Solution {
    int[][] keypad = {
        {1, 3},
        {0, 0}, {1, 0}, {2, 0},
        {0, 1}, {1, 1}, {2, 1},
        {0, 2}, {1, 2}, {2, 2}
    };
    int[] right = {2, 3};
    int[] left = {0, 3};
    StringBuilder sb = new StringBuilder();
    
    public String solution(int[] numbers, String hand) {
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                clickLeft(number);
            } else if (number == 3 || number == 6 || number == 9) {
                clickRight(number);
            } else {
                int leftLength = calcLength(left, keypad[number]);
                int rightLength = calcLength(right, keypad[number]);
                if (leftLength > rightLength) {
                    clickRight(number);
                } else if (leftLength < rightLength) {
                    clickLeft(number);
                } else {
                    if (hand.equals("right")) {
                        clickRight(number);
                    } else {
                        clickLeft(number);
                    }
                }
            }
        }
        return sb.toString();
    }
    
    private void clickLeft(int number) {
        sb.append("L");
        left = keypad[number];
    }
    private void clickRight(int number) {
        sb.append("R");
        right = keypad[number];
    }
    private int calcLength(int[] a, int[] b) {
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
}
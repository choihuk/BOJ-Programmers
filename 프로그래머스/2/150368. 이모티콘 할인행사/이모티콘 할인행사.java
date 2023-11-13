class Solution {
    int[][] users;
    int[] emoticons;
    int[] temp;
    int[] answer;
    int[] answerEmoticons;
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        this.temp = new int[emoticons.length];
        this.answer = new int[2];
        
        dfs(0);
        return answer;
    }
    
    private void dfs(int index) {
        if (index == emoticons.length) {
            int[] result = countEmoticonPlus();
            if (answer[0] < result[0]) {
                answer[0] = result[0];
                answer[1] = result[1];
            } else if (answer[0] == result[0] && answer[1] < result[1]) {
                answer[1] = result[1];
            }
        } else {
            for (int i=40; i>0; i-=10) {
                temp[index] = i;
                dfs(index+1);
            }
        }
    }
    
    private int[] countEmoticonPlus() {
        int count = 0;
        int totalSum = 0;
        for (int[] user : users) {
            int sum = 0;
            for (int i=0; i<temp.length; i++) {
                if (temp[i] >= user[0]) {
                    sum += emoticons[i] * (100-temp[i])/100;
                }
            }
            if (user[1] <= sum) {
                count++;
            } else {
                totalSum += sum;
            }
        }
        return new int[] {count, totalSum};
    }
}
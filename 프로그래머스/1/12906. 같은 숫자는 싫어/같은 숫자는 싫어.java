import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr[0]);
        for (int i=1; i<arr.length; i++) {
            int last = stack.peek();
            if (last != arr[i]) {
                stack.push(arr[i]);
            }
        }
        
        int length = stack.size();
        int[] result = new int[length];
        for(int i=length-1; i>=0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}
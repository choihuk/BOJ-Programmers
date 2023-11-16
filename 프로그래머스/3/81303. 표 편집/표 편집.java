import java.util.*;

class Solution {
    Node cn = new Node(null, null, 0);
    
    public String solution(int n, int k, String[] cmd) {
        Stack<Node> stack = new Stack<>();
        for (int i=1; i<n; i++) {
            Node node = new Node(cn, null, i);
            cn.next = node;
            cn = node;
        }
        up(n-k-1);
        
        for (String c : cmd) {
            String[] arr = c.split(" ");
            if (arr[0].equals("U")) {
                up(Integer.parseInt(arr[1]));
            } else if (arr[0].equals("D")) {
                down(Integer.parseInt(arr[1]));
            } else if (arr[0].equals("C")) {
                stack.push(cn);
                if (cn.pre != null) cn.pre.next = cn.next;
                if (cn.next != null) cn.next.pre = cn.pre;
                cn = cn.next == null ? cn.pre : cn.next;
            } else {
                Node node = stack.pop();
                if (node.pre != null) node.pre.next = node;
                if (node.next != null) node.next.pre = node;
            }
        }
        while(cn.pre != null) {
            cn = cn.pre;
        }
        
        StringBuilder sb = new StringBuilder();
       for(int i=0; i<n; i++){
            if(cn != null){
                if(cn.idx != i) sb.append('X');
                else{
                    sb.append('O');
                    cn = cn.next;
                }
            }else sb.append('X');
        }
        return sb.toString();
    }
    
    private void down(int num) {
        while (num --> 0) {
            cn = cn.next;
        }
    }
    
    private void up(int num) {
        while (num --> 0) {
            cn = cn.pre;
        }
    }
    
    static class Node {
        Node pre, next;
        int idx;
        public Node(Node pre, Node next, int idx) {
            this.pre = pre;
            this.next = next;
            this.idx = idx;
        }
    }
}
import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        
        int cx = 0;
        int cy = 0;
        for(String dir : dirs.split("")) {
            if (dir.equals("U") && cy < 5) {
                int cyp = cy + 1;
                set.add(cx+","+cy+","+cx+","+ cyp);
                set.add(cx+","+ cyp +","+cx+","+ cy);
                cy = cyp;
            } else if (dir.equals("D") && cy > -5) {
                int cym = cy - 1;
                set.add(cx+","+cy+","+cx+","+ cym);
                set.add(cx+","+ cym +","+cx+","+ cy);
                cy = cym;
            } else if (dir.equals("R") && cx < 5) {
                int cxp = cx + 1;
                set.add(cx+","+cy+","+ cxp +","+ cy);
                set.add(cxp +","+cy+","+cx+","+ cy);
                cx = cxp;
            } else if (dir.equals("L") && cx > -5) {
                int cxm = cx - 1;
                set.add(cx+","+cy+","+ cxm +","+ cy);
                set.add(cxm +","+cy+","+cx+","+ cy);
                cx = cxm;
            }
        }
        
        return set.size()/2;
    }
}
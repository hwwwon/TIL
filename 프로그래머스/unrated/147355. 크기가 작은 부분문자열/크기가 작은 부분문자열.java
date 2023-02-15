import java.util.*;
class Solution {
    public int solution(String t, String p) {
        String str = "";
        int cnt = 0;

        for(int i = 0; i <= t.length() - p.length(); i++){
            str = t.substring(i, i+p.length());
            if(Long.parseLong(str) <= Long.parseLong(p)) cnt++;
        }

        return cnt;
    }
}
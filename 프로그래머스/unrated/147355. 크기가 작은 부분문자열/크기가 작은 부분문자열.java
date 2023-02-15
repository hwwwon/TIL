import java.util.*;
class Solution {
    public int solution(String t, String p) {
        String str = "";
        ArrayList<Long> list = new ArrayList<>();
        for(int i = 0; i < t.length(); i++){
            if(t.length()-i < p.length()) break;
            str = t.substring(i, i+p.length());
            list.add(Long.parseLong(str));
        }
        int cnt = 0;
        for(Long i : list){
            if(i <= Long.parseLong(p)) cnt++;
        }
        
        return cnt;
    }
}
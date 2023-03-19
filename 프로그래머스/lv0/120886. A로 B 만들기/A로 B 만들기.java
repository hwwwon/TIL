import java.util.*;
class Solution {
    public int solution(String before, String after) {
        int length = before.length();
        char[] b = before.toCharArray();
        char[] a = after.toCharArray();
        Arrays.sort(b);
        Arrays.sort(a);
        for(int i = 0; i < before.length(); i++){
            if(b[i] == a[i]) length -= 1;
        }
        if(length == 0) return 1;
        return 0;
    }
}
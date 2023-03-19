import java.util.*;
class Solution {
    public int solution(String before, String after) {
        char[] b = before.toCharArray();
        char[] a = after.toCharArray();
        Arrays.sort(b);
        Arrays.sort(a);
        return new String(b).equals(new String(a)) ? 1 : 0;
    }
}
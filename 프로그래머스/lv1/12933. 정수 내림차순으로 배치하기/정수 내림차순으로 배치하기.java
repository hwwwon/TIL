import java.util.*;
class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        String answer = "";
        String[] arr = s.split("");
        Arrays.sort(arr, Comparator.reverseOrder());
        for(String v : arr){
            answer += v;
        }
        return Long.parseLong(answer);
    }
}
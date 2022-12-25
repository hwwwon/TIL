import java.util.*;
class Solution {
    public int[] solution(long n) {
        int len = (int)(Math.log10(n)+1);
        int[] arr = new int[len];

        for(int i = 0; i < len; i++){
           arr[i] = (int)(n % 10);
           n = (int)(n / 10);
        }
        
        return arr;
    }
}
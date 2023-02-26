import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int sum = 0; 
        for(int i = score.length-1; i >= 0; i-=m){
            if(i-(m-1) < 0) break;
            int min = score[i-(m-1)];
            sum += min * m;
        }
        
        return sum;
    }
}
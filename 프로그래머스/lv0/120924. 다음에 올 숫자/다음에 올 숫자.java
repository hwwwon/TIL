import java.util.*;
class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int i = common.length-1;
        if (common[i] - common[i - 1] == common[i - 1] - common[i - 2])
           answer = (common[i] - common[i-1]) + common[i];
        else answer = (common[i] / common[i-1]) * common[i]; 
        return answer;
    }
}
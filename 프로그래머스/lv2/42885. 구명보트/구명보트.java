import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;
        Arrays.sort(people);
        for(int i = 0, j = people.length-1; i < people.length && j >= i; j--){
            cnt++;
            if(people[i] + people[j] <= limit){
                i++;
            }
        }
        return cnt;
    }
}
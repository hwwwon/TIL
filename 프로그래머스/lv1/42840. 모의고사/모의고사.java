import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        List<Integer> list = new ArrayList<>();
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2,1,2,3,2,4,2,5};
        int[] num3 = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i = 0; i < answers.length; i++){
            if(num1[i%5] == answers[i]) answer[0]++;
            if(num2[i%8] == answers[i]) answer[1]++;
            if(num3[i%10] == answers[i]) answer[2]++;
        }
        
        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        
        for(int i = 0; i < 3; i++) 
            if(answer[i] == max) list.add(i+1);
        
        return list.stream().mapToInt(v -> v).toArray();
    }
}
import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] newEmergency = Arrays.copyOf(emergency, emergency.length);
        Arrays.sort(newEmergency);
        for(int i = 0; i < emergency.length; i++){
            for(int j = 0; j < newEmergency.length; j++){
                if(emergency[i] == newEmergency[j]) answer[j] = emergency.length - i;
            }
        }
        return answer;
    }
}
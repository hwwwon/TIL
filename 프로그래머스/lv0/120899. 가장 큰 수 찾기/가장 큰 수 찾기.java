import java.util.*;
class Solution {
    public int[] solution(int[] array) {
//         ArrayList<Integer> list = new ArrayList<Integer>();
//         int max = 0;
//         int index = 0;
//         for(int i = 0; i < array.length; i++){
//             if(max < array[i]){
//                 max = array[i];
//                 index = i;
//             }
//         }
        
//         list.add(max);
//         list.add(index);
        
//         return list.stream().mapToInt(Integer :: intValue).toArray();
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                maxIndex = i;
            }
        }
        int[] answer = {max, maxIndex};
        return answer;
    }
}
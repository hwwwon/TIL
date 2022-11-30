import java.util.*;
class Solution {
    public int[] solution(int n) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = n; i > 0; i--){
            if(i % 2 == 1){
                list.add(i);
            }
        }
        
        Collections.sort(list);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
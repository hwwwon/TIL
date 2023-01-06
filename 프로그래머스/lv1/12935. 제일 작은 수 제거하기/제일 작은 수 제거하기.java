import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        ArrayList<Integer> list = new ArrayList<>();
        int min = arr[0];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
                index = i;
            }
            list.add(arr[i]);
        }
        list.remove(index);

        return list.stream().mapToInt(Integer :: intValue).toArray();
    }
}
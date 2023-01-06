import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[index] > arr[i]){
                index = i;
            }
            list.add(arr[i]);
        }
        list.remove(index);

        return list.stream().mapToInt(Integer :: intValue).toArray();
    }
}
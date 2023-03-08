import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        ArrayList<Integer> list = new ArrayList<>();
        int min = 0;
        for(int i : array){
            if(i >= n)   min = i - n;
            else   min = n - i;
            list.add(min);
        }
        int index = list.indexOf(Collections.min(list));
        return array[index];
    }
}
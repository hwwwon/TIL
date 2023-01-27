import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] arr = new String[strings.length];
        for(int i = 0; i < strings.length; i++){
            arr[i] = Character.toString(strings[i].charAt(n)) + strings[i];
        }
        Arrays.sort(arr);
        for(int j = 0; j < arr.length; j++){
            arr[j] = arr[j].substring(1);
        }
        return arr;
    }
}
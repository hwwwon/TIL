import java.util.*;
class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        String[] arr2 = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            arr2[i] = Character.toString(arr[i]);
        }
        Arrays.sort(arr2, Collections.reverseOrder());
        return String.join("",arr2);
    }
}
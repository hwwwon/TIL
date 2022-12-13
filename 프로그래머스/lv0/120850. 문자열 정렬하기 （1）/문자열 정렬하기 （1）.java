import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        String str = my_string.replaceAll("[^0-9]","");
        int[] list = Arrays.stream(str.split("")).sorted().mapToInt(Integer::parseInt).toArray();

        return list;
    }
}
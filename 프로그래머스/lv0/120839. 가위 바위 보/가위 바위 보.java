
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String rsp) {   
        // char[] arr = rsp.toCharArray();
        // String str = "";
        // for(char a : arr){ 
        //     str += (a == '2') ?  "0" : a == '0' ? "5" : "2"; 
        // }
        
        return rsp.chars().mapToObj(num -> String.valueOf( (char)num == '2'  ?  "0" : (char)num == '0' ? "5" : "2")).collect(Collectors.joining());
    }
}
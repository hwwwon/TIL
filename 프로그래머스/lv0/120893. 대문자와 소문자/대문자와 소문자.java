import java.util.*;
class Solution {
    public String solution(String my_string) {
        char[] arr = my_string.toCharArray();  
        String s = "";
        
        for(char a : arr){
            if(Character.isUpperCase(a)){
                s += Character.toLowerCase(a);
            }else{
                s += Character.toUpperCase(a);
            }
        }
        
        return s;
        
    }
}
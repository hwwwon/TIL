import java.util.Arrays;
class Solution {
    public String solution(String my_string, int n) {
        
        String a = "";
        char[] arr = new char[my_string.length()];
        
        for(int i = 0; i < my_string.length(); i++){
            
            arr[i] = my_string.charAt(i);
            
            for(int j = 0; j < n; j++){
                a += arr[i];
            }
            
        }
        
        return a;
    }
}

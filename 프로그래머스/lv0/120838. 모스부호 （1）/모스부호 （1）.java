import java.util.*;
class Solution {
    public String solution(String letter) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] arr = letter.split(" ");
        String answer = "";
        for(String a : arr){
            for(int i = 0; i < morse.length; i++){
                if(a.equals(morse[i])){
                    answer += (char)('a' + i);
                    break;
                }
            }
        }
        
        return answer;
    }
}
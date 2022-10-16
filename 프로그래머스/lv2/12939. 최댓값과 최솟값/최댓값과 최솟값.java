import java.util.Arrays;
class Solution {
    public String solution(String s) {                
        
        String arr[] = s.split(" ");
        int arr2[] = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        int maxNum = arr2[0];
        int minNum = arr2[0];
        
        for(int i = 0; i < arr2.length; i++){
            
            if(maxNum <= arr2[i]){
                maxNum = arr2[i];
            }
            if(minNum >= arr2[i]){
                minNum = arr2[i];
            }
            
            
        }
           
        
        String answer = minNum + " " + maxNum;
        return answer;
    }
}
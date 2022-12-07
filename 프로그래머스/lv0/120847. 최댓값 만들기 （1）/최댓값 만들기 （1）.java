class Solution {
    public int solution(int[] numbers) {
        
        int first = 0, second = 0;
        
        for(int num : numbers){
            if(num >= first){
                second = first;
                first = num;
            }else if(num >= second && num != first){
                second = num;
            }
        }
        
        return first * second;
    }
}
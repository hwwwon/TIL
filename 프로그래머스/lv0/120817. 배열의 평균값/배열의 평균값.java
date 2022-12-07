class Solution {
    public double solution(int[] numbers) {
        
        int sum = 0;
        double answer = 0;
        
        for(int num : numbers){
            answer = (double)(sum += num) / numbers.length;
        }
        
        
        return answer;
    }
}
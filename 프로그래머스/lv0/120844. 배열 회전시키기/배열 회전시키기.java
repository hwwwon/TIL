class Solution {
    public int[] solution(int[] numbers, String direction) {
        int temp1 = numbers[0];
        int temp2 = numbers[numbers.length-1];
        if(direction.equals("left")){
            for(int i = 1; i < numbers.length; i++){
                numbers[i-1] = numbers[i];
            }
            numbers[numbers.length - 1] = temp1;
        }else{
            for(int i = numbers.length-1; i > 0; i--){
                numbers[i] = numbers[i-1];
            }
            numbers[0] = temp2;
        }
        
        return numbers;
    }
}
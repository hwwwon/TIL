class Solution {
    public String solution(String phone_number) {
        
        int num = phone_number.length()-4;
        
        String end_number = phone_number.substring(num);
        
        String answer = phone_number.substring(0, num).replaceAll(".","*") + end_number;
        return answer;
    }
}
class Solution {
    public String solution(int age) {
        char[] arr = String.valueOf(age).toCharArray();
        String answer = "";
        for(int i = 0; i < arr.length; i++){
            answer += (char)(arr[i] + 49);
        }

        return answer;
    }
}
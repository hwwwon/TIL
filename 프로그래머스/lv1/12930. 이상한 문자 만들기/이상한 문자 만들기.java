class Solution {
    public String solution(String s) {
        // String answer = "";
        // int cnt = 0;
        // char[] arr = s.toCharArray();
        // for(int i = 0; i < arr.length; i++){
        //     String a = Character.toString(arr[i]);
        //     cnt++;
        //     if(a.equals(" ")) cnt = 0;
        //     if(cnt % 2 == 1) a = a.toUpperCase();
        //     else a = a.toLowerCase();
        //     answer += a;
        // }
        // return answer;
        String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for(String ss : array) {
            cnt = ss.contains(" ") ? 0 : cnt + 1;
            answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase(); 
        }
        return answer;
    }
}
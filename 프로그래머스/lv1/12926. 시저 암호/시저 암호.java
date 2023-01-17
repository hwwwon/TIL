class Solution {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        String result = "";
        for(char c : arr){
            if(c >= 65 && c <= 90){
                for(int i = 1; i <= n; i++){
                    c += 1;
                    if(c > 90) c = 65;
                }
            }else if(c >= 97 && c <= 122){
                for(int i = 1; i <= n; i++){
                    c += 1;
                    if(c > 122) c = 97;
                }
            }
            result += Character.toString(c);
        }
        return result;
    }
}
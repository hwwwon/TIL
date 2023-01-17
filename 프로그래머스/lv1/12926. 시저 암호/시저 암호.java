class Solution {
    public String solution(String s, int n) {
        String result = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)) c = (char)((c - 'A' + n) % 26 + 'A');
            else if(Character.isLowerCase(c)) c = (char)((c - 'a' + n) % 26 + 'a');
            result += c;
        }
        return result;
    }
}
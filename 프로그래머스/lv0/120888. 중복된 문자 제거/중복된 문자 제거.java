class Solution {
    public String solution(String my_string) {
        String s = "";
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.indexOf(my_string.charAt(i)) == i)  s += my_string.charAt(i);
        }
        return s;
    }
}
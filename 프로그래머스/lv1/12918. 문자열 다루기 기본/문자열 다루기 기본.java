class Solution {
    public boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6){
            return false;
        } else {
            char[] arr = s.toCharArray();
            for(char a : arr){
                if((int) a < 48 || (int) a > 57) return false;
            }
        }
        return true;
    }
}
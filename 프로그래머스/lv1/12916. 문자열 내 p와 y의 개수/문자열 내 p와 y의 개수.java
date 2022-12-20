class Solution {
    boolean solution(String s) {
        int p = 0, y = 0;
        boolean result = true;
        s = s.toUpperCase();
        for(char str : s.toCharArray()){
            if(str == 'P') p++;
            if(str == 'Y') y++;
        }
        result = p == y ? true : false;
        return result;
    }
}
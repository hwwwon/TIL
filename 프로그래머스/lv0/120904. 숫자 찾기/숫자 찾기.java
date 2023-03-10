class Solution {
    public int solution(int num, int k) {
        String s = " " + String.valueOf(num);
        return s.indexOf(String.valueOf(k));
    }
}
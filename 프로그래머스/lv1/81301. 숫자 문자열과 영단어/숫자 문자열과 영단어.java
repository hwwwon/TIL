class Solution {
    public int solution(String s) {
        String[] st = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int result = 0;
        for(int i = 0; i < 10; i++){
            s = s.replace(st[i], String.valueOf(i));
        }
        return Integer.valueOf(s);
    }
}
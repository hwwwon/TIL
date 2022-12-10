class Solution {
    public int solution(int n, int t) {
        int s = 0;
        for(int i = 0 ; i < t; i++){
            s = n * 2;
            n = s;
        }
        return s;
    }
}
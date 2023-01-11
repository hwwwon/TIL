class Solution {
    public int solution(int left, int right) {
        int cnt, sum = 0;
        for(int i = left; i <= right; i++){
            cnt = 0;
            for(int j = 1; j <= i; j++){
                if(i % j == 0) cnt++;
            }
            sum += cnt % 2 == 1 ? -i : i;
        }
        return sum;
    }
}
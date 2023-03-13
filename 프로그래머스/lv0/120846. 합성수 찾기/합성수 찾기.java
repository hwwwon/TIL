class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n>3){
            int cnt = 0;
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(i*j == n) cnt++;
                }
                if(cnt == 3){
                    answer++;
                    break;
                }
            }
            n--;
        }
        return answer;
    }
}
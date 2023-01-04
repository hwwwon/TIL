class Solution {
    public int solution(int num) {
        long n = num;
        int cnt;
        
        for(cnt = 0; cnt <= 500; cnt++){
            if(n == 1){
                break;
            }else if(n % 2 == 0){
                n = n / 2;
            }else{
                n = n * 3 + 1;
            }
        }
        
        if(cnt > 500) cnt = -1;
        
        return cnt;
    }
}
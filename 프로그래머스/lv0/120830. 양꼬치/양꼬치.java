class Solution {
    public int solution(int n, int k) {
        
        int d = k;
    
        if(n >= 10){
            d = k - n / 10;
        }
        
        int total = n * 12000 + d * 2000;
        
        return total;
    }
}
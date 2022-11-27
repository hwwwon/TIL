class Solution {
    public int solution(int slice, int n) {
        
        int pizza = 0;
        
        if(slice >= n){
            pizza = 1;
        }else if (n % slice == 0){
            pizza = n / slice;
        }else{
            pizza = n / slice + 1;
        }
        
        return pizza;
    }
}
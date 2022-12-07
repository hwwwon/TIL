class Solution {
    public int solution(int n) {
        
        int pizza = 0;
        int max = 6;
        
        if(n > 6){
            max = n;
        }        
   
        for(int i = max; i >= max; i++){
            if(i % n == 0 && i % 6 == 0){
                pizza = i / 6;
                break;
            }
        }
                
        return pizza;
    }
}
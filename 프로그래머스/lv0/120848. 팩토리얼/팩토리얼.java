class Solution {
    public int solution(int n) {  
        int num = 0, fac = 1;
        while(true){
            if(fac <= n){
                fac *= num + 1;
                num++;
            }else break;
        }
        return num - 1;
    }    
}
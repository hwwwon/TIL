class Solution {
    public int solution(int[] sides) {
        
        int max = 0, sum = 0;
        
        for(int s : sides){
            if(max < s){
                max = s;
            }
            sum += s;
        }
        
        if(sum - max > max){
            return 1;
        }else{
            return 2;
        }
        
    }
}
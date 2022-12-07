class Solution {
    public int solution(int[] array, int n) {
        
        int count = 0;
        
        for(int arr : array){
            if(arr == n){
                count++;
            }
        }
        
        return count;
        
    }
}
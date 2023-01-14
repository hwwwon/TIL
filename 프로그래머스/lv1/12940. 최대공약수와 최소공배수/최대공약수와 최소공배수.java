class Solution {
    public int[] solution(int n, int m) {
        int[] arr = new int[2];
        int max = Math.max(n,m);
        int min = Math.min(n,m);
        for(int i = 1; i <= max; i++){
            if(max%i == 0 && min%i == 0) arr[0] = i;
            arr[1] = max * min / arr[0] ;
        }
        return arr;
    }
}
class Solution {
    public int solution(int[] arr) {
        int num = arr[0];
        for(int i = 1; i < arr.length; i++){
            num = (num * arr[i]) / GCD(num, arr[i]);
        }
        return num;
    }
    public int GCD(int a, int b){
        int max = 0;
        for(int i = 1; i <= a && i <= b; i++){
            if(a % i == 0 && b % i == 0) max = i;
        }
        return max;
    }
}
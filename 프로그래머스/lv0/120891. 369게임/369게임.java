class Solution {
    public int solution(int order) {
        char[] arr = String.valueOf(order).toCharArray();
        int cnt = 0;
        for(char a : arr){
            if(a % 3 == 0 && a != '0') cnt++;
        }
        return cnt;
    }
}
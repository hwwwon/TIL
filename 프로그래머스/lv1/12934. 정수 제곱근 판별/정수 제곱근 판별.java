class Solution {
    public long solution(long n) {
        if(Math.pow(Math.floor(Math.sqrt(n)),2) == n){
            return (long) Math.pow(Math.floor(Math.sqrt(n))+1, 2);
        }else{
            return (long)-1;
        }
    }
}
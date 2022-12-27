class Solution {
    public boolean solution(int x) {
        String str = "" + x ;
        char[] arr = str.toCharArray();
        int a = 0;
        for(int i  = 0; i < arr.length; i++){
            a += (arr[i] - 48);
        }
        if(x % a != 0){
            return false;
        }
        return true;
    }
}
class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        String result = "";
        for(int i = 0; i < arr.length; i++){
            if(arr.length % 2 == 1){
                result = String.valueOf(arr[arr.length / 2]);
            }else{
                result = String.valueOf(arr[arr.length / 2 - 1]) + String.valueOf(arr[arr.length / 2]);
            }
            
        }
        return result;
    }
}
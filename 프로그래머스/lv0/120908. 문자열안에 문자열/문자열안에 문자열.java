class Solution {
    public int solution(String str1, String str2) {
       if(str1.replace(str2, "").equals(str1)){
           return 2;
       }else{
           return 1;
       }
    }
}
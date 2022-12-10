class Solution {
    public int solution(String my_string) {
        
        String[] str = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int num = 0;
        
        for(int i = 0; i < my_string.length(); i++){
            for(int j = 0; j < str.length; j++){
                if(my_string.substring(i, i+1).equals(str[j])){
                    num += Integer.parseInt(str[j]);
                }
            }
        }
        
        return num;
    }
}
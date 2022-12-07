class Solution {
    public String solution(String my_string) {
        
        String[] str = {"a","e","i","o","u"};
        String a = my_string;
        
        for(String s : str){
            if(my_string.contains(s)){
                a = my_string.replace(s, "");
                my_string = a;
            }
        }
        
        return a;
    }
}
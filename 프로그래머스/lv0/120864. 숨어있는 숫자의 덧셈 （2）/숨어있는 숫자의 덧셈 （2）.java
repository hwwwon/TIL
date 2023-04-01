class Solution {
    public int solution(String my_string) {
        char[] arr = my_string.toCharArray();
        String s = "";
        for(char a : arr){
            if((int)a >= 48 && (int)a <= 57)  s += a;
            else s += ",";
        }
        String[] num = s.split(",");
        int answer = 0;
        for(String n : num){
            if(!n.equals("")) answer += Integer.parseInt(n);
        }
        return answer;
    }
}
class Solution {
    public int solution(int i, int j, int k) {
        String str = "";
        int cnt = 0;
        for(int z = i; z <= j; z++){
            str += String.valueOf(z);
        }
        char[] ch = str.toCharArray();
        for(char c : ch){
            if((int)(c - '0') == k) cnt++;
        }
        return cnt;
    }
}
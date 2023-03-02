class Solution {
    public int solution(String s) {
        int cnt = 0;
        while(s.length() > 0){
            int first = 1, other = 0;
            cnt++;
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) == s.charAt(0)) first++;
                else other++;
                if(first == other) break;
            }
            s = s.substring(first+other);
        }
        
        return cnt;
    }
}
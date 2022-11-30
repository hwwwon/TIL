class Solution {
    public int solution(int n) {
        String s = Integer.toString(n);
        int sum = 0;
        for(int i = 0; i < s.length(); i++){  
            sum += Integer.parseInt(s.substring(i,i+1));
        }
        
        return sum;
    }
}
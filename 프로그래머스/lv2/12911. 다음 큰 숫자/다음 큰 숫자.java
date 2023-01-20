class Solution {
    public int solution(int n) {
        // String a = Integer.toBinaryString(n).replace("0","");
        // int one = a.length();
        // while(true){
        //     n++;
        //     int cnt = 0;
        //     String s = Integer.toBinaryString(n);
        //     for(int i = 0; i < s.length(); i++){
        //         if(s.charAt(i) == '1') cnt++;
        //     }
        //     if(cnt == one) break;
        // }
        // return n;
        int one = Integer.bitCount(n);
        int result = n+1;
        while(true){
            if(one == Integer.bitCount(result)) break;
            result++;
        }
        return result;
    }
}
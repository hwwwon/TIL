class Solution {
    public int[] solution(String s) {
        int[] arr = new int[2];
        while(true) {
            int leng = s.length();
            s = s.replace("0", "");
            arr[1] += leng - s.length();
            s = Integer.toBinaryString(s.length());
            arr[0]++;
            if(s.equals("1")) break;
        }    
        return arr;
    }
}
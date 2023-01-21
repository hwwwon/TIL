class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            String a = Integer.toBinaryString(arr1[i]);
            String b = Integer.toBinaryString(arr2[i]);
            a = "0".repeat(n-a.length()) + a;
            b = "0".repeat(n-b.length()) + b;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(a.charAt(j) == '1'|| b.charAt(j) == '1') sb.append("#");
                else sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}
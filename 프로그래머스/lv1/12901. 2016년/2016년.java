class Solution {
    static String[] week = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
    public int month(int a){
        if(a == 1 || a == 3 || a == 5 || a == 7 || a == 8 || a == 10 || a == 12) return 31;
        if(a == 4 || a == 6 || a == 9 || a == 11) return 30;
        return 29;
    }
    public String day(int b){
        String answer = "";
        for(int i = 0; i < 7; i++){
            if(b == i) answer = week[i];
        }
        return answer;
    }
    public String solution(int a, int b) {
        int sumDay = 0;
        for(int i = 1; i < a; i++){
            sumDay += month(i);
        }
        return day((sumDay + b) % 7);
    }
}
class Solution {
    public int solution(int hp) {
        
        int five = hp / 5;
        int three = (hp - five * 5) / 3;
        int one = (hp - five * 5 - three * 3) / 1;

        return five + three + one;
    }
}
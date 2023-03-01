import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> c1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> c2 = new LinkedList<>(Arrays.asList(cards2));
        for(int i = 0; i < goal.length; i++){
            if(goal[i].equals(c1.peek())) c1.poll();
            else if(goal[i].equals(c2.peek())) c2.poll();
            else return "No";
        }
        
        return "Yes";
    }
}
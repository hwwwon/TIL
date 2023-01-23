import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();
        int index = 0;
        if(s.length() == 0){
            return 0;
        }
        
        while(index < s.length()){
            char c = s.charAt(index++);
            if( !st.isEmpty() && st.peek() == c) st.pop();
            else st.push(c);
        }
        return st.isEmpty() ? 1 : 0;
    }
}
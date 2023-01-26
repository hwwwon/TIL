class Solution {
    public int[] solution(int n, String[] words) {
        for(int i=1; i<words.length; i++) {
            if((words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)) || words[i].length() == 1)
                return new int[]{i%n+1, i/n+1};
            
            for(int j=0; j<i; j++)
                if(words[j].equals(words[i]))
                    return new int[]{i%n+1, i/n+1};
        }
        
        return new int[]{0, 0};
    }
}
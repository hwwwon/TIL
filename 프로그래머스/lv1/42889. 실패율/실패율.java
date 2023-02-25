import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        double[][] answer = new double[N][2];
        int[] result = new int[N];
        double fail = 0;
        
        for(int i = 1; i <= N; i++){
            int p = 0, n = 0;
            for(int j = 0; j < stages.length; j++){
                if(i <= stages[j]) p++;
                if(i == stages[j]) n++;
            }
            fail = (double)n / (double)p * 100.0;
            answer[i-1][0] = p == 0 ? 0 : fail;
            answer[i-1][1] = i;
            
        }
        
        Arrays.sort(answer, (o1, o2) -> { 
           return o1[0] == o2[0] ? Double.compare(o1[1], o2[1]) : Double.compare(o2[0], o1[0]);
        });
        
        for(int i = 0; i < N; i++){
            result[i] = (int)answer[i][1];
        }
        
        return result;
    }
}
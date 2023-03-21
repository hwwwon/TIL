import java.util.*;
class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] arr = new int[num_list.length/n][n];
        int num = 0;
        for(int i = 0; i < num_list.length/n; i++){
            for(int j = 0; j < n; j++, num++){
                arr[i][j] = num_list[num];
            }
        }
        return arr;
    }
}
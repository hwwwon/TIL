class Solution {
    public int solution(int[][] sizes) {
        int row = 0, column = 0, tmp = 0;
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            if(row < sizes[i][0]) row = sizes[i][0];
            if(column < sizes[i][1]) column = sizes[i][1];
        }
        
        return row*column;
    }
}
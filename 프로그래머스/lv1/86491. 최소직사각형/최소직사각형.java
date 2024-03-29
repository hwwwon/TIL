class Solution {
    public int solution(int[][] sizes) {
//         int row = 0, column = 0, tmp = 0;
//         for(int i = 0; i < sizes.length; i++){
//             if(sizes[i][0] < sizes[i][1]){
//                 tmp = sizes[i][0];
//                 sizes[i][0] = sizes[i][1];
//                 sizes[i][1] = tmp;
//             }
//             if(row < sizes[i][0]) row = sizes[i][0];
//             if(column < sizes[i][1]) column = sizes[i][1];
//         }
        
//         return row*column;
        int row = 0, column = 0;
        for(int[] size : sizes){
            row = Math.max(row, Math.max(size[0],size[1]));
            column = Math.max(column, Math.min(size[0],size[1]));
        }
        return row*column;
    }
}
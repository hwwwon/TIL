class Solution {
    public int[] solution(int brown, int yellow) {
        int[] size = new int[2];
        int total = brown + yellow;
        for(int i = 1; i <= total; i++){
            int height = total / i;
            if(total % i == 0 && i >= height && (i-2)*(height-2) == yellow){
                size[0] = i;
                size[1] = height;
                break;
            }
        }
        return size;
    }
}
class Solution {
    public String solution(int[] food) {
        String p1 = "", p2 = "0";
        for(int i = 1; i < food.length; i++){
            for(int j = 1; j <= food[i]/2; j++){
                p1 += String.valueOf(i);
            }
        }
        for(int i = food.length-1; i > 0; i--){
            for(int j = 1; j <= food[i]/2; j++){
                p2 += String.valueOf(i);
            }
        }

        return p1+p2;
    }
}
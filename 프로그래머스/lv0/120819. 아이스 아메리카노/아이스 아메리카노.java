class Solution {
    public int[] solution(int money) {
        
        int[] arr = new int[2];
        int count = 0;

        while(money >= 5500){
            money -= 5500;
            count++;
        }
        
        arr[0] = count;
        arr[1] = money;
  
        return arr;
    }
}
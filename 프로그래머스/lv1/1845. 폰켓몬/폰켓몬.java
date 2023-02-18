import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], "포켓몬");
        }
        if(map.size() > nums.length/2) return nums.length/2;
        return map.size();
    }
}
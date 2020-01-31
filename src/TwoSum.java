import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int mul = target - nums[i];
            if (map.containsKey(mul)){
                return new int[]{map.get(mul), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

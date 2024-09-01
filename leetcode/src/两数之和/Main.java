package 两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gallantsa
 * @version 1.0
 * @date 2024年09月02日 7:26
 */
public class Main {
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) return new int[]{i, map.get(num)};
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    System.out.println("answer=" + Arrays.toString(twoSum2(new int[] {2, 7, 11, 15}, 26)));
    long endTime = System.nanoTime();
    long duration = (endTime - startTime) / 1000000; // divide by 1000000 to get milliseconds.
    System.out.println("method's execution time=" + duration + "ms");
  }

  // O(n²)
  public static int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i != j && nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return new int[] {};
  }
  // O(n)
  public static int[] twoSum2(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; map.put(nums[i], i++)) {
      if (map.containsKey(target - nums[i])) return new int[] {map.get(target - nums[i]), i};
    }
    return new int[2];
  }
}

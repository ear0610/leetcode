package leetcode.easy;

import java.util.Arrays;

public class SquaresOfASortedArray {
  /*
    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].
  */
  public static void main(String[] args) {
    System.out.println(Arrays.toString(sortedSquares(new int[] {-4, 1, 8, 9, 10})));
  }

  public static int[] sortedSquares(int[] nums) {
    int length = nums.length;
    int i = 0;
    int j = length - 1;
    int[] result = new int[length];
    for (int p = length - 1; p >= 0; p--) {
      if (Math.abs(nums[i]) > Math.abs(nums[j])) {
        result[p] = nums[i] * nums[i];
        i++;
      } else {
        result[p] = nums[j] * nums[j];
        j--;
      }
    }
    return result;
  }
}

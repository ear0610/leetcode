package leetcode.easy;

public class BinarySearch {
  public static void main(String[] args) {
    System.out.println(solution(new int[] {-1, 0, 3, 5, 9, 12}, 9));
  }

  public static int search(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (target == nums[i]) return i;
    }
    return -1;
  }

  /**
   * Time complexity : O(log N)
   * @param nums 數列
   * @param target 目標
   * @return 目標位置
   */
  public static int solution(int[] nums, int target) {
    int pivot;
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      pivot = left + (right - left) / 2;
      if (nums[pivot] == target) return pivot;
      if (target < nums[pivot]) right = pivot - 1;
      else left = pivot + 1;
    }
    return -1;
  }
}

package leetcode.easy;

public class SearchInsertPosition {
  public static void main(String[] args) {
    // System.out.println(searchInsert(new int[] {1, 2, 4, 7}, 3));
    System.out.println(searchInsert(new int[] {1, 2, 4, 7}, 9));
  }

  public static int searchInsert(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    int mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (target == nums[mid]) return mid;
      else if (target < nums[mid]) end = mid - 1;
      else start = mid + 1;
    }
    return start;
  }
}

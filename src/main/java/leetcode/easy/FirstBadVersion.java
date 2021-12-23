package leetcode.easy;

public class FirstBadVersion {
  private static final int badVersion = 6;

  public static void main(String[] args) {
    System.out.println(firstBadVersion(9));
  }

  public static int firstBadVersion(int n) {
    int start = 1;
    int end = n;
    int mid;
    while (start < end) {
      mid = start + (end - start) / 2;
      if (!isBadVersion(mid)) start = mid + 1;
      else end = mid;
    }
    return start;
  }

  public static boolean isBadVersion(int version) {
    return version >= badVersion;
  }
}

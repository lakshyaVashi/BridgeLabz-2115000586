import java.util.*;

public class PairWithTargetSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 7, 12, 15};
        int target = 11;
        System.out.println(hasPairWithSum(nums, target)); 
    }
}

package BinarySearch;

/**
 * Created by Administrator on 2017/6/6.
 */
public class Binary81SearchInRotatedSortedArrayII {
    /**
     * 不会做! 6/5/2017
     * https://discuss.leetcode.com/topic/25487/neat-java-solution-using-binary-search
     * 主要是根据lo mid hi的关系, 找到万全的条件来移动lo和hi
     * 1. 先想好以mid分界, 哪边一定是sorted array,
     * 2. 再根据target与sorted array的关系, 找lo hi移动的条件
     * 3. 单独提出来nums[lo] == nums[mid] == nums[hi]很不容易!
     */
    public boolean searchFakeBinary(int[] nums, int target) {
        if (nums == null || nums.length == 0)  {
            return false;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[lo] > nums[mid] || nums[mid] < nums[hi]) { //right side must be sorted
                if (nums[mid] < target && target <= nums[hi]) {//注意<=的=别忘了啊!
                    lo = mid;
                } else {
                    hi = mid;
                }
            } else if (nums[lo] < nums[mid] || nums[mid] > nums[hi]) { //left side must be sorted
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            } else { //three values equals!
                hi--;
            }
        }
        if (nums[lo] == target || nums[hi] == target)  {
            return true;
        }
        return false;
    }
}
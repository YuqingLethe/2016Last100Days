package HashMap;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by me on 1/18/21.
 *
 * You are given an integer array nums and an integer k.

 In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

 Return the maximum number of operations you can perform on the array.



 Example 1:

 Input: nums = [1,2,3,4], k = 5
 Output: 2
 Explanation: Starting with nums = [1,2,3,4]:
 - Remove numbers 1 and 4, then nums = [2,3]
 - Remove numbers 2 and 3, then nums = []
 There are no more pairs that sum up to 5, hence a total of 2 operations.
 Example 2:

 Input: nums = [3,1,3,4,3], k = 6
 Output: 1
 Explanation: Starting with nums = [3,1,3,4,3]:
 - Remove the first two 3's, then nums = [1,4,3]
 There are no more pairs that sum up to 6, hence a total of 1 operation.


 Constraints:

 1 <= nums.length <= 105
 1 <= nums[i] <= 109
 1 <= k <= 109
 Hide Hint #1
 The abstract problem asks to count the number of disjoint pairs with a given sum k.
 Hide Hint #2
 For each possible value x, it can be paired up with k - x.
 Hide Hint #3
 The number of such pairs equals to min(count(x), count(k-x)), unless that x = k / 2, where the number of such pairs will be floor(count(x) / 2).
 */
public class HT1679MaxNumberofKSumPairs {

    /**
     *
     * 20210118 Use 45min
     * Runtime: 35 ms, faster than 45.70% of Java online submissions for Max Number of K-Sum Pairs.
     * Memory Usage: 53.1 MB, less than 60.84% of Java online submissions for Max Number of K-Sum Pairs.
     *
     * 1. 当允许set里面有dup的时候，注意HashSet不能用，而HashMap也不能有重复的！HashMap doesn't allow duplicate keys but allows duplicate values.
     * 2. for (Integer i : Integer[] nums)的时候for loop的是nums[x]而不是index
     * 3. HashMap不能通过value查找key，因此需要查找mapping的必须放在key，而key和value都验证存不存在
     * @param nums
     * @param k
     * @return
     */
    private static int maxOperationHT(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        int res = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = k - nums[i];
            int one = nums[i];
            if (hash.containsKey(other) && hash.get(other) > 0) {
                res ++;
                hash.put(other, hash.get(other) - 1);
            } else if (hash.containsKey(one)) {
                hash.put(one, hash.get(one) + 1);
            } else {
                hash.put(one, 1);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums1 = {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int[] nums2 = {1,2,3,4};
        int[] nums3 = {3,1,3,4,3};
        int k1 = 3;
        int k2 = 5;
        int k3 = 6;
        HT1679MaxNumberofKSumPairs thisIssue = new HT1679MaxNumberofKSumPairs();
        int res = thisIssue.maxOperationHT(nums3, k3);
        System.out.println(res);

    }


    /**
     * 20210118 Use 25min
     *
     * Runtime: 16 ms
     * Memory Usage: 52.9 MB
     * @param nums
     * @param k
     * @return
     */
    public int maxOperationsByTwoPointers(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0, j = arr.length - 1;i < j;) {
            int sum = arr[i] + arr[j];

            if (sum == k) {
                res ++;
                i ++;
                j --;
            } else if (sum > k) {
                j --;
            } else {
                i ++;
            }
        }
        return res;
    }
}

package LintCode.Binary.Recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
public class LintRecursive15Permutation {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        ArrayList<Integer> subset = new ArrayList<>();
        helper (subset, nums, results);
        return results;
    }
    private void helper (ArrayList<Integer> subset,
                         int[] nums,
                         List<List<Integer>> results) {
        if (subset.size() == nums.length) { //只有凑够三个才add
            results.add(new ArrayList<Integer>(subset));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(subset.contains(nums[i])){
                continue;
            }
            subset.add(nums[i]);
            helper(subset, nums, results);
            subset.remove(subset.size() - 1);
        }
    }
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     *
    size=1
    1
    size=1
    2 1
    1 2
    size=2
    3 2 1
    2 3 1
    2 1 3
    3 1 2
    1 3 2
    1 2 3
     */
    public List<List<Integer>> permuteNonrecursive(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int n : nums) {
            //当开始进行nums[i]时，res中的结果是nums[0]至nums[i-1]的全排列。
            int size = res.size();
            System.out.println("size="+size);
            //在每个位置添加nums[i]然后加到res末尾（第三个for loop，循环r.size()次
            for (; size > 0; size--) {
                List<Integer> r = res.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
                    List<Integer> t = new ArrayList<Integer>(r);
                    t.add(i, n);
                    for (Integer tmp : t) {
                        System.out.print(tmp + " ");
                    }
                    System.out.println();
                    res.add(t);
                }
            }
        }
        return res;
    }
}

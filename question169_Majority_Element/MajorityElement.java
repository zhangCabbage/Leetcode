package zhang.algorithm.leetcode.question169_Majority_Element;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/8
 * Time: 上午10:42
 * To change this template use File | Settings | File Templates.
 * <p>
 * update:
 * Date: 16/12/1
 * Time: 下午7:39
 * we can use at least four method to deal with it:
 * 1) sort and find
 * 2) hashmap
 * 3) bit manipulation(use to instead of hashmap)
 * 4) moore voting
 * <p>
 * Review Time: 2017-03-25 10:56:11
 */
public class MajorityElement {
    /**
     * The way that solve this problem is in the beautify of programming
     * moore voting
     * <p>
     * <strong>result of test:</strong><br/>
     * 42 / 42 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 68.17%
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int num = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
                count++;
            } else {
                if (num == nums[i]) count++;
                else count--;
            }
        }

        return num;
    }
}

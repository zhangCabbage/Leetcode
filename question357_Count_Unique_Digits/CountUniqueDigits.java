package zhang.algorithm.leetcode.question357_Count_Unique_Digits;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 16/10/27
 * Time: 下午9:06
 * To change this template use File | Settings | File Templates.
 */
public class CountUniqueDigits {
    /**
     * this problem the unique digit is mean that the number contains at less two same digit.
     * eg: 11、22、121...
     * How to deal it?
     * I have try to use two method to solve this problem, but still can not.
     *
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        return countIs0(n) + countNot0(n);
    }

    public int countIs0(int bit) {
        if (bit == 1) return 1;
        return (11 - bit) * countIs0(bit - 1) + (10 - bit) * countNot0(bit - 2);
    }

    public int countNot0(int bit) {
        if (bit == 1) return 9;
        return (10 - bit) * countNot0(bit - 1);
    }


    public int countNumbersWithUniqueDigits2(int n) {
        if (n > 10) n = 10;
        int[] map = new int[10];
        return helper(map, 0, n);
    }

    private int helper(int[] map, int index, int bit) {
        if (index == bit) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < map.length; i++) {
                if (map[i] != 1) {
                    map[i] = 1;
                    count += helper(map, index + 1, bit);
                    map[i] = 0;
                }
            }
            return count;
        }
    }

    //------------------------------------------------------------------------------------------
    //right answer, MDZZ
    //------------------------------------------------------------------------------------------

    /**
     * 应用组合数字中的知识, 从1位一直加到n位, 初始0位结果为1
     * <p>
     * 9 / 9 test cases passed
     * Status: Accepted
     * Runtime: 0 ms, bit 12.97%
     *
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits3(int n) {
        if (n > 10) n = 10;

        int ans = 1;
        int tmp = 1;
        int[] map = {9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < n; i++) {
            tmp *= map[i];
            ans += tmp;
        }

        return ans;
    }

    public static void main(String[] args) {
        CountUniqueDigits test = new CountUniqueDigits();
        int n = 2;
        System.out.println(test.countNumbersWithUniqueDigits2(n));
    }
}

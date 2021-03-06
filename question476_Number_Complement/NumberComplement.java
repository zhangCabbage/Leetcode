package zhang.algorithm.leetcode.question476_Number_Complement;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/2/26
 * Time: 下午7:58
 * To change this template use File | Settings | File Templates.
 */
public class NumberComplement {
    /**
     * 找到原始数中为0的数, 然后标记
     * 149 / 149 test cases passed.
     * Status: Accepted
     * Runtime: 11 ms, bit 59.54%
     *
     * @param num
     * @return
     */
    public int findComplement(int num) {
        int highestOneBit = highestOneBit(num);
        int result = -1 & ((1 << highestOneBit) - 1);

        return result ^ num;
    }

    private int highestOneBit(int num) {
        if (num == 0) return 0;
        int bit = 1;

        if ((num >>> 16) > 0) {
            bit += 16;
            num >>>= 16;
        }
        if ((num >>> 8) > 0) {
            bit += 8;
            num >>>= 8;
        }
        if ((num >>> 4) > 0) {
            bit += 4;
            num >>>= 4;
        }
        if ((num >>> 2) > 0) {
            bit += 2;
            num >>>= 2;
        }

        return bit + (num >>> 1);
    }

    /**
     * @param num
     * @return
     */
    public int findComplement2(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

    /**
     * This way can be run, but Above is faster!
     * <p>
     * The sum of num and it's complement num is 2^n-1(11.....111),
     * so we can do like this.
     *
     * @param num
     * @return
     */
    public int findComplement3(int num) {
        return (Integer.highestOneBit(num) << 1) - 1 - num;
    }


    public static void main(String[] args) {
        NumberComplement test = new NumberComplement();
        System.out.println(test.findComplement(1));

        System.out.println(Integer.toBinaryString(12));
        System.out.println(Integer.toBinaryString(~12));
        System.out.println(Integer.toBinaryString(-12));
    }
}

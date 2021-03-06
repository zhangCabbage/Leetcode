package zhang.algorithm.leetcode.question292_Nim_Game;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/7
 * Time: 下午3:19
 * To change this template use File | Settings | File Templates.
 */
public class NimGame {
    /**
     * this problem is also very interesting!!
     * two side also can take one \ two \ three stone, and two side is also smart.
     * if I can finally take the last stone, I win.
     * <p>
     * 分析后我们知道,当剩下四个的时候,谁先拿,谁死!,我们努力使得最后剩下四个!!
     * 这是一个很有技巧的题,那么发散思维:当我们可以赢的时候,我们该如何拿石头才能赢呢?
     * 第一次拿 n%4 (if n > 4 && n/4 != 0)个, 我们就能赢!
     * <p>
     * Attention that this problem`s tag is Brainteaser(脑筋急转弯)!
     * <p>
     * <strong>result of test:</strong><br/>
     * 60 / 60 test cases passed
     * Status: Accepted
     * Runtime: 0 ms, bit 2.4%
     *
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return (n & 3) != 0;
    }
}

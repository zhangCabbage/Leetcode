package zhang.algorithm.leetcode.question142_Linked_List_Cycle_II;

import zhang.algorithm.modelUtil.List.ListNode;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/5
 * Time: 上午10:12
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListCycleII {
    /**
     * Can you solve it without using extra space?
     * <p>
     * <strong>result of test:</strong><br/>
     * 16 / 16 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 19.44%
     * <p>
     * reference:[【142. Linked List Cycle II】](http://www.jianshu.com/p/ce7f035daf74)
     * Detail is in this reference. I do not to talk twice.
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode first = head;
        ListNode second = head.next;

        //first
        while (first != second) {
            first = first.next;
            second = (second.next == null) ? null : second.next.next;
            if (second == null) return null;
        }

        //second
        first = head;
        second = second.next;//pay attention about this place.

        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
}

package zhang.algorithm.leetcode.question160_Intersection_Two_Linked_Lists;

import zhang.algorithm.modelUtil.List.LinkedListTools;
import zhang.algorithm.modelUtil.List.ListNode;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/3
 * Time: 下午11:33
 * To change this template use File | Settings | File Templates.
 */
public class IntersectionTwoLinkedLists {

    /**
     * <strong>result of test:</strong><br/>
     * 42 / 42 test cases passed
     * Status: Accepted
     * Runtime: 2 ms, bit 34.83%
     * <p>
     * 《Beauty of programming》Have explanation. You can see and update!
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB;
        if (tempA == null || tempB == null) return null;

        int lenA = 0;
        int lenB = 0;
        while (tempA != null || tempB != null) {
            if (tempA != null) {
                lenA++;
                tempA = tempA.next;
            }
            if (tempB != null) {
                lenB++;
                tempB = tempB.next;
            }
        }
        //This is the fault place!!
        int temp = (lenA < lenB) ? 0 : lenA - lenB;
        lenB = (lenB < lenA) ? 0 : lenB - lenA;
        lenA = temp;

        tempA = headA;
        tempB = headB;
        for (int i = 0; i < lenA; i++) {
            tempA = tempA.next;
        }
        for (int i = 0; i < lenB; i++) {
            tempB = tempB.next;
        }
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }


    /**
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null | headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }


    public static void main(String[] args) {
        int[] nums1 = {1};
        ListNode root1 = LinkedListTools.factory(nums1);
        int[] nums2 = {2, 3};
        ListNode root2 = LinkedListTools.factory(nums2);

        IntersectionTwoLinkedLists test = new IntersectionTwoLinkedLists();
        test.getIntersectionNode(root1, root2);
    }
}

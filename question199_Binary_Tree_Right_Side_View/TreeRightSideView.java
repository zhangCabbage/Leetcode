package zhang.algorithm.leetcode.question199_Binary_Tree_Right_Side_View;

import zhang.algorithm.modelUtil.Tree.BinaryTree;
import zhang.algorithm.modelUtil.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/7/24
 * Time: 下午2:49
 * To change this template use File | Settings | File Templates.
 */
public class TreeRightSideView {
    /**
     * use the level traversal method to deal with this problem.
     * <strong>result of test:</strong><br/>
     * 210 / 210 test cases passed
     * Status: Accepted
     * Runtime: 3 ms, bit 13.02%
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (i == size - 1) res.add(curNode.val);
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
        }
        return res;
    }

    /**
     * I also think this way to deal. But I not to coding.
     * I find that use the recursive way is more faster than use the queue data construct.
     * <p>
     * 1、every level only one node can be add to the array
     * 2、
     * <p>
     * 210 / 210 test cases passed
     * Status: Accepted
     * Runtime: 1 ms, bit 81.42%
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) return;
        if (currDepth == result.size()) {
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }

    public List<Integer> rightSideView3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightSideView(res, root, 0);
        return res;
    }

    /**
     * Review Time: 2017-03-16 21:02:09
     * list.add(index, num), list is not array, so 我们不能像使用数组一样的想通过add替换掉index位置处的元素
     * Error!!!
     *
     * @param res
     * @param root
     * @param level
     */
    public void rightSideView(List<Integer> res, TreeNode root, int level) {
        //先序遍历
        if (root == null) return;
        res.add(level, root.val);
        rightSideView(res, root.left, level + 1);
        rightSideView(res, root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeRightSideView test = new TreeRightSideView();
        int[] nums = {1, 2, 3};
        test.rightSideView3(BinaryTree.instance(nums).getRoot());
    }
}

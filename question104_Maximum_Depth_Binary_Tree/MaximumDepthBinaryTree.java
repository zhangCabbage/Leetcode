package zhang.algorithm.leetcode.question104_Maximum_Depth_Binary_Tree;

import zhang.algorithm.modelUtil.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang_zack on 16/6/10.
 */
public class MaximumDepthBinaryTree {
    /**
     * this problem is to find the maximum depth of binary tree.<br/>
     * My first mind is to use the way of last problem that level order traversal<br/>
     * Now let's do it in this way. use breadth-first-traversal way is more complexity<br/>
     * <br/>
     * <strong>result of test:</strong><br/>
     * 38 / 38 test cases passed.<br/>
     * Status: Accepted<br/>
     * Runtime: 4 ms,击败3.34%<br/>
     * <br/>
     * but I think it must has other better way.<br/>
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int depth = 0;
        int curIndex = 1;
        int levelIndex = 0;
        int nextLevelIndex = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.offer(root);
            nextLevelIndex++;
        }

        TreeNode curNode = null;
        while (!queue.isEmpty()) {
            if (curIndex == levelIndex + 1) {
                depth++;
                levelIndex = nextLevelIndex;
            }
            curNode = queue.poll();
            curIndex++;
            if (curNode.left != null) {
                queue.offer(curNode.left);
                nextLevelIndex++;
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
                nextLevelIndex++;
            }
        }

        return depth;
    }

    /**
     * use depth-first-traversal in recursive way, maybe not use queue so is more quickly.
     * <br/>
     * <strong>result of test:</strong><br/>
     * 38 / 38 test cases passed<br/>
     * Status: Accepted<br/>
     * Runtime: 1 ms, bit 10.33%<br/>
     * <br/>
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth2(root.left);
        int rightMax = maxDepth2(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }
}

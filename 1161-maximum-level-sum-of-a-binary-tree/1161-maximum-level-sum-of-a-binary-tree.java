/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        long maxSum = Long.MIN_VALUE;
        int level = 0;
        int maxLevel = 0;

        while (!deque.isEmpty()) {
            long levelSum = 0;
            int size = deque.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                levelSum += node.val;
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            if(maxSum < levelSum){
                maxSum = levelSum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
    // time complexity O(n)
    // space complexity O(n)
}
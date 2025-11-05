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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;

        return countPaths(root, (long) targetSum)
                + pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum);
    }

    private int countPaths(TreeNode node, long target){
        if(node == null)
            return 0;

        int cnt = 0;
        
        if (node.val == target) cnt++;

        cnt += countPaths(node.left, target - node.val);
        cnt += countPaths(node.right, target - node.val);

        return cnt;
    }
    // time complexity O(n^2)
    // space complexity O(n)
}
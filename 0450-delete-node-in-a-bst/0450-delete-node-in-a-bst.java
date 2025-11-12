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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root== null || (root.right == null && root.right == null && root.val == key))
            return null;
        TreeNode curr = root;
        TreeNode prev = null;
        boolean isPrevLeftNode = false;
        while (curr != null) {
            if (curr.val == key) {
                if(isPrevLeftNode){
                    prev.left = curr.left;
                    prev.left.right = curr.right;
                    curr = null;
                }else{
                    prev.right = curr.left;
                    prev.left.right = curr.right;
                    curr = null;
                }
            } else if (key < curr.val) {
                prev = curr;
                isPrevLeftNode = true;
                curr = curr.left;
            } else {
                prev = curr;
                isPrevLeftNode = true;
                curr = curr.right;
            }
        }
        return root;
    }
    // time complexity O(n)
    // space complexity O(1)
}
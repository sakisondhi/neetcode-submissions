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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTTraverse(root.left, Integer.MIN_VALUE, root.val) && isValidBSTTraverse(root.right, root.val, Integer.MAX_VALUE);
    }

    private boolean isValidBSTTraverse(TreeNode root, int min_value, int max_value){
        if(root==null) return true;

        if(root.val <= min_value || root.val >= max_value) return false;

        return isValidBSTTraverse(root.left, min_value, root.val) && isValidBSTTraverse(root.right, root.val, max_value);
    }
}

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
    int res;
    public void traverseDfs(TreeNode root, int currentMax){
        if(root == null) return;

        if(root.val>=currentMax) res++;

        currentMax = Math.max(currentMax, root.val);

        traverseDfs(root.left, currentMax);
        traverseDfs(root.right, currentMax);
    }
    public int goodNodes(TreeNode root) {
        traverseDfs(root, -101);
        return res;
    }
}

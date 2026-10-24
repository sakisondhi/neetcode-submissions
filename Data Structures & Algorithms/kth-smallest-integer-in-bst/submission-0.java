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
    int traverseIndex = 1;
    int res, f=0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if(root==null) return;

        traverse(root.left, k);
        if(k==traverseIndex && f==0){
            res = root.val;
            f=1;
            return;
        }
        traverseIndex++;
        traverse(root.right, k);
    }

}

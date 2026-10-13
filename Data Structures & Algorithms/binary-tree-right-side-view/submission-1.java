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
    List<Integer> rsv = new ArrayList<>();
    private void dfs(TreeNode root, int depth){
        if(root==null) return;

        if(rsv.size() == depth) rsv.add(root.val);

        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);

        return rsv;

        // if(root==null) return rsv;

        // Queue<TreeNode> q = new LinkedList<>();
        // q.offer(root);
        // q.offer(null);

        // while(!q.isEmpty()){
        //     TreeNode top = q.poll();
        //     if(top == null){
        //         if(q.isEmpty()) continue;
        //         else{
        //             q.offer(null);
        //         }
        //     }else{
        //         if(top.left !=null) q.offer(top.left);
        //         if(top.right != null) q.offer(top.right);

        //         if(q.peek() == null ) rsv.add(top.val);
        //     }
        // }

        // return rsv;

    }
}

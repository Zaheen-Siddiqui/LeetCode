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
    private int Max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        Traversal(root);

        return Max;
    }

    public int Traversal(TreeNode root){

        if( root == null)
            return 0;
        
        int left = Math.max(0, Traversal(root.left));
        int right = Math.max(0, Traversal(root.right));

        Max = Math.max(Max, left + root.val + right);

        return root.val + Math.max(left, right);
    }
}

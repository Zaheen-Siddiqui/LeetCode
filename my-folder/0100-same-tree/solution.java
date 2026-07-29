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
    private boolean same = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Traversal(p, q);

        return same;
    }

    public void Traversal(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return;

        if(p == null || q == null){
            same = false;
            return;
        }

        if(q.val != p.val)
            same = false;

        Traversal(p.left, q.left);
        Traversal(p.right, q.right);
    }
}

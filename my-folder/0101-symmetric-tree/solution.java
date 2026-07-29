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
    private boolean Symmetry = true;
    public boolean isSymmetric(TreeNode root) {
        traversal(root.left, root.right);

        return Symmetry;
    }

    public void traversal(TreeNode RL, TreeNode RR){
        if(RR == null && RL == null)
            return;
        
        if(RR == null || RL == null){
            Symmetry = false;
            return;
        }

        if(RR.val != RL.val)
            Symmetry = false;

        traversal(RL.right, RR.left);
        traversal(RL.left, RR.right);
    }
}

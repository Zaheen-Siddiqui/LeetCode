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
    private int MaxDepth = 0;
    public int maxDepth(TreeNode root) {
        Traversal(root, 0);

        if(root == null)
            return 0;
        
        return MaxDepth + 1;
    }

    public void Traversal(TreeNode root, int depth){
        if(root == null)
            return;
        
        if(depth > MaxDepth)
            MaxDepth = depth;
        
        Traversal(root.left, depth + 1);
        Traversal(root.right, depth + 1);
    }
}

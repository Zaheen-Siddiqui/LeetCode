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
    Queue<Integer> queue = new LinkedList<>();
    public void flatten(TreeNode root) {
        traversal(root);

        if(root == null)
            return;

        root.left = null;
        root.right = null; // Disconnects the decendant node

        queue.poll(); // Remove the first item in queue

        for(Integer item : queue){
            root.right = new TreeNode(item);
            root = root.right;
        }
    }
    public void traversal(TreeNode root){
        if(root == null)
            return;
        
        queue.add(root.val);

        traversal(root.left);
        traversal(root.right);

    }
}

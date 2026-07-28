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
    HashMap<Integer, Integer> map = new HashMap<>();

    public List<Integer> rightSideView(TreeNode root) {

        traversal(root, 0);

        return new ArrayList<>(map.values());
    }
    public void traversal(TreeNode root, int depth){
        if (root == null)
            return;

        map.put(depth, root.val);
        
        traversal(root.left, depth + 1);
        traversal(root.right, depth + 1);
    }
}

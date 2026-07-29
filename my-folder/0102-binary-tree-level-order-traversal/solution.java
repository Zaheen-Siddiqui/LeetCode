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
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); 
    public List<List<Integer>> levelOrder(TreeNode root) {    
        Traversal(root, 0);
        
        return new ArrayList<>(map.values());
    }

    public void Traversal(TreeNode root, int depth){
        if(root == null)
            return;
        
        if(map.containsKey(depth)){
            map.get(depth).add(root.val);
        }
        else{
            map.put(depth, new ArrayList<>());
            map.get(depth).add(root.val);
        }

        Traversal(root.left, depth + 1);
        Traversal(root.right, depth + 1);

    }
}

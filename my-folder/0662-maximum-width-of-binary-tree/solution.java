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
    HashMap<Integer, HashMap<String, Long>> map = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        traversal(root, 1L, 0);
        long width = 1;
        for (Integer outerKey : map.keySet()) {
            width = Math.max(width, (map.get(outerKey).get("Max") - map.get(outerKey).get("Min") + 1));
        }
        return (int)width;
    }

    public void traversal(TreeNode root, long num, int depth){
        if (root == null)
            return;
        if(map.containsKey(depth)){
            HashMap<String, Long> innerMap = map.get(depth);

            innerMap.put("Max", Math.max(innerMap.get("Max"), num));
            innerMap.put("Min", Math.min(innerMap.get("Min"), num));
        }
        else{
            HashMap<String, Long> innerMap = new HashMap<>();
            innerMap.put("Max", num);
            innerMap.put("Min", num);
            map.put(depth, innerMap);
        }
        
        // map.put(num, depth);
        traversal(root.left, 2 * num, depth + 1);
        traversal(root.right, (2 * num) + 1,  depth + 1);
    }
}

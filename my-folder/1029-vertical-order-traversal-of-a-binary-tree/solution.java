class Solution {
    TreeMap<Integer, List<int[]>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traversal(root, 0, 0);

        List<List<Integer>> result = new ArrayList<>();

        for (List<int[]> list : map.values()) {
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0])
                    return a[1] - b[1]; 
                return a[0] - b[0];     
            });

            List<Integer> column = new ArrayList<>();
            for (int[] node : list) {
                column.add(node[1]);
            }

            result.add(column);
        }

        return result;
    }

    public void traversal(TreeNode root, int row, int col) {
        if (root == null)
            return;

        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new int[]{row, root.val});

        traversal(root.left, row + 1, col - 1);
        traversal(root.right, row + 1, col + 1);
    }
}

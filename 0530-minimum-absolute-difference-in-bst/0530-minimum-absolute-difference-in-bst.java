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
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode now = q.poll();
            list.add(now.val);

            if (now.left != null) {
                q.offer(now.left);
            }      
            if (now.right != null) {
                q.offer(now.right);
            }
        }
        // Integer[] array = list.toArray(new Integer[0]);
        Collections.sort(list);
        for (int i=0; i<list.size()-1; i++) {
                min = Math.min(min, list.get(i+1)-list.get(i));
        }
        return min;
    }
}
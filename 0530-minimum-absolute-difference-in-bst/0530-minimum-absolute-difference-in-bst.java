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
                min = Math.min(min, now.val-now.left.val);
            }      
            if (now.right != null) {
                q.offer(now.right);
                min = Math.min(min, now.right.val-now.val);
            }
            if (min==1) return 1;
        }
        Integer[] array = list.toArray(new Integer[0]);
        Arrays.sort(array);
        for (int i=0; i<array.length-1; i++) {
                min = Math.min(min, array[i+1]-array[i]);
        }
        return min;
    }
}
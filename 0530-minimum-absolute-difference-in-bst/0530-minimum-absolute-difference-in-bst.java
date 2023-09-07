class Solution {
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root, pre = null;
        int res = Integer.MAX_VALUE;
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.pop();
                if (pre != null) res = Math.min(res, curr.val - pre.val);
                pre = curr;
                curr = curr.right;
            }
        }
        return res;
    }
}
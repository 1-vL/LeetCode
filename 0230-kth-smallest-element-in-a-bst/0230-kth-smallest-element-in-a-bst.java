class Solution {
    int cnt=1;
    int kcnt;
    int answer;
    public int kthSmallest(TreeNode root, int k) {
        kcnt = k;
        inOrder(root);
        return answer;
    }

    public void inOrder(TreeNode node) {
        if (node == null || cnt > kcnt) { return; }
        inOrder(node.left);
        if (cnt==kcnt) { answer=node.val; }
        cnt++;
        inOrder(node.right);
    }
}
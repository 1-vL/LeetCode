class Solution {
    int cnt=0;
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
        cnt++;
        if (cnt==kcnt) { answer=node.val; }
        inOrder(node.right);
    }
}
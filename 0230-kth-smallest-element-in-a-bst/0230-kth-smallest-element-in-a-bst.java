class Solution {
    int cnt=1;
    int answer;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return answer;
    }

    public void inOrder(TreeNode node, int k) {
        if (node == null) { return; }
        inOrder(node.left, k);
        if (cnt==k) { answer=node.val; }
        cnt++;
        inOrder(node.right, k);
    }
}
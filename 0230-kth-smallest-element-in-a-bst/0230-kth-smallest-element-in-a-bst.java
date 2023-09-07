class Solution {
    public static int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return ans;
    }

    public int helper(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        int leftCount = helper(root.left, k); // k번째 요소 탐색
        int rightCount = helper(root.right, k - leftCount - 1); // 왼쪽 하위노드에서 체크한 수 만큼 제외한 k - leftCount - 1번째 요소 탐색
        if (k == leftCount + 1) { // 정답 찾음(1인덱스)
            ans = root.val;
        }
        return leftCount + rightCount + 1; // 좌우 노드의 체크한 요소들 갯수의 합
    }
}
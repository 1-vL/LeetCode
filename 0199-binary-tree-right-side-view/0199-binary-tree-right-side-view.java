class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int level_pushed = 1; // root 요소 1개
        int level_polled = 0;
        if (root == null) { return answer; }

        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode now = q.poll();
            level_polled++;

            if (now.left!=null) {
                q.offer(now.left);
            }
            if (now.right!=null) {
                q.offer(now.right);
            }
            if (level_pushed==level_polled) { // 한 높이의 마지막 요소
                answer.add(now.val);
                level_pushed = q.size();
                level_polled = 0;
            } // 높이 초기화
        }
        return answer;
    }
}
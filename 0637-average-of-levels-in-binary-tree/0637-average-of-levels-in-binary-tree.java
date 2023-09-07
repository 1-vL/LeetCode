class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        Double sum = 0.0;
        int cnt = 0; // root
        int level_cnt = 1; // root

        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode now = q.poll();
            level_cnt--;
            cnt++;
            
            sum += now.val;
            if (now.left!=null) {
                q.offer(now.left);
            }

            if (now.right!=null) {
                q.offer(now.right);
            }

            if (level_cnt==0) {
                answer.add(sum/cnt);
                sum = 0.0;
                level_cnt = q.size();
                cnt = 0;
            }
        }

        return answer;
    }
}
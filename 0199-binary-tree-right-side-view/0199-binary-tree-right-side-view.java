class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();        
        if (root == null) { return answer; }
        
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            
            while (size-- > 0){
                TreeNode now = q.poll();
                if (size == 0) {
                    answer.add(now.val);
                }
                if (now.left!=null) {
                    q.offer(now.left);
                }
                if (now.right!=null) {
                    q.offer(now.right);
                }
            }
        }
        
        return answer;
    }
}
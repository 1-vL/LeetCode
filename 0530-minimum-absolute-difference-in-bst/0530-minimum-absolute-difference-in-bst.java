class Solution {
    static int min;
    static int before_val;
    public int getMinimumDifference(TreeNode root) {
        // static 변수 초기화
        before_val=-1;
        min  = Integer.MAX_VALUE;
        Inorder(root); // 루트노드 중위순회
        return min;
    }
        
    
    void Inorder(TreeNode node) {
        if(node == null) { return; } // 리프노드
        Inorder(node.left); // 왼쪽 재귀
        // 이전 값이 존재하면
        if (before_val>=0) {
            // 오름차순 순회이므로 현재값에서 이전값을 뺀 값(차이)가 min보다 작은지 체크
            min = Math.min(min, node.val-before_val);
        }
        System.out.println(node.val + " " + before_val);
        before_val = node.val;
        Inorder(node.right); // 오른쪽 재귀
    }
}
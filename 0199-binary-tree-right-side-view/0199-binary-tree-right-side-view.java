
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        var list = new ArrayList<Integer>();
        rec(root,list,0);
        return list;
    }
    void rec(TreeNode root,ArrayList<Integer> list, int depth){
        if (root == null) return;
        if(list.size()==depth) list.add(root.val);
        if(root.right!=null) rec(root.right,list,depth+1);
        if(root.left!=null) rec(root.left,list,depth+1);
    }
}
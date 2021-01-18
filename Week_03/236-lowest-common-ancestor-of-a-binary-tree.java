class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1、当root为空时，表示非法结点，直接返回 root，其实等价于直接返回null
        // 2、当root等于p或等于q时，表示找到了目标结果，返回root，等价于找到了目标
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左右子数都非空，说明在左右子数分别找到了p和q，所以root就是祖先
        if(left != null && right != null) {
            return root;
        }

        // 左右子数都是空，说明他不可能是祖先，直接返回null，这种试错，是回溯的思想
        if(left == null && right == null) {
            return null;
        }

        // 返回不为空的那个节点，表示找到了其中的一个孙子
        return left == null ? right : left;
    }
}
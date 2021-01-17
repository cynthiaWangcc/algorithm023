import java.util.HashMap;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {
    HashMap<Integer, Integer> index_Map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length) {
            return null;
        }

        // 建立hash表，提高查找root的速度
        for(int i = 0; i < preorder.length; i++) {
            index_Map.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if(preorderLeft > preorderRight) {
            return null;
        }

        // 先创建 根结点
        TreeNode root = new TreeNode(preorder[preorderLeft]);

        // 计算左子数的长度
        int index_root = index_Map.get(preorder[preorderLeft]);
        int left_length = index_root - inorderLeft;

        root.left = buildTree(preorder, inorder, preorderLeft + 1, preorderLeft + left_length, inorderLeft, index_root - 1);
        root.right = buildTree(preorder, inorder, preorderLeft + 1 + left_length, preorderRight, index_root + 1, inorderRight);
        return root;
    }
}
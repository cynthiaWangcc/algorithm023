#include <iostream>

using namespace std;

/**
 * Definition for a binary tree node.
 */
class Solution {
    typedef struct TreeNode {
        int val;
        TreeNode *left;
        TreeNode *right;
        TreeNode(int x) :val(x), left(NULL), right(NULL){}
    }TreeNode;

    TreeNode *ans;
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        dfs(root, p, q);
        return ans;
    }

    bool dfs(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == NULL)
        {
            return false;
        }
        
        bool lson = dfs(root -> left, p, q);
        bool rson = dfs(root -> right, p, q);

        if ((lson && rson) || ((root -> val == p -> val || root -> val == q -> val) && (lson || rson))) {
            ans = root;
        }

        return lson || rson || (root->val == p->val || root -> val == q -> val);
    }
};

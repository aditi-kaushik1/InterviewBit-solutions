/* Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
Both the left and right subtrees must also be binary search trees. */

public class Solution {
    public int isValidBST(TreeNode A) {
        return isValidBST(A, null, null);
    }
    
    public int isValidBST(TreeNode root, Integer min, Integer max) {
        if(root == null)
            return 1;
        if((min != null && root.val <= min) || (max != null && root.val >= max))
            return 0;
        
        return isValidBST(root.left, min, root.val) & isValidBST(root.right, root.val, max);
    }
}

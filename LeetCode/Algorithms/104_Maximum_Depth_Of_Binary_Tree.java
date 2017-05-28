/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root != null) {
            int leftValue = 1;
            int rightValue = 1;
        
            if(root.left != null) {
                leftValue += maxDepth(root.left);
            }
        
            if(root.right != null) {
                rightValue += maxDepth(root.right);
            }
        
            if(leftValue > rightValue) {
                return leftValue;
            } else {
                return rightValue;
            }
        } else {
            return 0;
        }
    }
}
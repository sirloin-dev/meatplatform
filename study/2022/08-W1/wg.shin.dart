class Solution {
  TreeNode? invertTree(TreeNode? root) {
    if(root == null){
        return null;
    }
    root as TreeNode;
    var left = root.left;
    var right = root.right;
    root.left = invertTree(right);
    root.right = invertTree(left);
    return root;
  }
}

/*
Runtime: 395 ms, faster than 100.00% of Dart online submissions for Invert Binary Tree.
Memory Usage: 142.5 MB, less than 100.00% of Dart online submissions for Invert Binary Tree.
*/

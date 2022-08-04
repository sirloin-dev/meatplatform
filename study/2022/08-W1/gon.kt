    class Solution {
        fun invertTree(root: TreeNode?): TreeNode? = root?.let {
            inverse(it)
            root
        }

        private fun inverse(root: TreeNode?) {
            root?.let {
                val a = it.left
                val b = it.right
                it.left = b
                it.right = a
                inverse(it.left)
                inverse(it.right)
            }
        }
    }

/*
 * DFS
 *
 * Runtime: 168 ms, faster than 87.75% of Kotlin online submissions for Invert Binary Tree.
 * Memory Usage: 33.5 MB, less than 97.83% of Kotlin online submissions for Invert Binary Tree.
 */
fun invertTree(root: TreeNode?): TreeNode? {
   if (root == null) {
       return null
   }

   val originalLeft = root.left
   root.left = invertTree(root.right)
   root.right = invertTree(originalLeft)

   return root
}


/*
 * BFS
 *
 * Runtime: 160 ms, faster than 91.50% of Kotlin online submissions for Invert Binary Tree.
 * Memory Usage: 33.8 MB, less than 87.88% of Kotlin online submissions for Invert Binary Tree.
 */
fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }

    val queue = LinkedList<TreeNode>()
    queue.add(root)

    while(queue.isNotEmpty()) {
        val currentNode = queue.poll()

        // 다음 처리할 Node 목록들을 queue 에 세트(swap 전후와는 관계없으나, '왼쪽부터 먼저' 를 달성하기 위해 미리 한다)
        currentNode.left?.let { queue.add(it) }
        currentNode.right?.let { queue.add(it) }

        val originalLeft = currentNode.left
        currentNode.left = currentNode.right
        currentNode.right = originalLeft
    }

    return root
}

/*
 * DFS
 *
 * Runtime: 196 ms, faster than 97.16% of Kotlin online submissions for Path Sum.
 * Memory Usage: 35.5 MB, less than 93.18% of Kotlin online submissions for Path Sum.
 *
 * BFS 풀이법: https://leetcode.com/problems/path-sum/discuss/1595806/112path-sum-iterative-bfs-c
 *
 * 다른 답들은 대부분 sum 을 더하는 방식 말고, 빼는 방식으로 
 */
fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) {
        return false
    }

    return hasPathSumInternal(root, targetSum, 0)
}

fun hasPathSumInternal(root: TreeNode, targetSum: Int, currentSum: Int): Boolean {
    if (root.left == null && root.right == null) {
        return currentSum + (root.`val`) == targetSum
    }

    if (root.left != null) {
        val result = hasPathSumInternal(root.left!!, targetSum, currentSum + root.`val`)
        // 처음에는 여기서 바로 return 했었는데 그러면 한방향으로만 탐색하기 때문에 결과가 제대로 나오지 않음. 반대쪽도 탐색해야 한다.
        if (result) {
            return true
        }
    }

    if (root.right != null) {
        return hasPathSumInternal(root.right!!, targetSum, currentSum + root.`val`)
    }
    
    return false
}

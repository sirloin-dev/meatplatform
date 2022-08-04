    
/*
    1. 왼쪽과 오른쪽 변환
    2. 왼쪽 재귀호출
    3. 오른쪽 재귀호출
    끝
    null이면 알아서 실행안되니 null경우느 걱정하 필요 없음
*/
class Solution {
    fun invertTree(root: TreeNode?): TreeNode? = root?.let {
        inverse(it)
        root
    }

    private fun inverse(root: TreeNode?) {
        root?.let {
            val l = it.left
            val r = it.right
            it.left = r
            it.right = l
            inverse(it.left)
            inverse(it.right)
        }
    }
}

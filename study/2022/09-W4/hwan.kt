/**
 * Runtime: 2916 ms, faster than 11.56% of Kotlin online submissions for Find if Path Exists in Graph.
 * Memory Usage: 229.1 MB, less than 17.22% of Kotlin online submissions for Find if Path Exists in Graph.
 *
 * Time complexity: O(N + Edges)
 * Space complexity: O(N + Edges)
 */
class Solution {
    private fun <T> ArrayDeque<T>.push(item: T): T = this.addLast(item).run { return item }
    private fun <T> ArrayDeque<T>.pop(): T = this.removeLast()

    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        // 굳이 계산할 필요 없는 사례
        if (source == destination) {
            return true
        }

        val graph = buildGraph(n, edges)
        if (!graph.containsKey(source)) {
            return false
        }

        // dfs.
        val path = ArrayDeque<Int>()    // Stack
        val visited = TreeSet<Int>()
        path.add(source)

        // 재귀로 하기 더 어려워서 그냥 loop 이용.
        while (path.isNotEmpty()) {
            val current = path.pop()
            visited.add(current)

            // current 로부터 역추적할 정보가 없으므로 길이 없다
            val nextNodes = graph[current] ?: return false

            for (nextNode in nextNodes) {
                // 이미 방문한 길은 다음 방문대상에 넣지 않는다. 안그러면 무한 Loop 문제 발생
                if (!visited.contains(nextNode)) {
                    path.push(nextNode)
                }
            }

            // 여기까지 도달하는 동안 visited 에 source 가 있다면, 길이 있다는 의미
            if (current == destination) {
                return visited.contains(source)
            }
        }

        return false
    }

    private fun buildGraph(n: Int, edges: Array<IntArray>): Map<Int, Set<Int>> {
        val graph = HashMap<Int, MutableSet<Int>>()

        for (i in 0 until n) {
            graph[i] = TreeSet()
        }

        for (edge in edges) {
            graph[edge[0]]!!.add(edge[1])
            graph[edge[1]]!!.add(edge[0])
        }

        return graph
    }
}

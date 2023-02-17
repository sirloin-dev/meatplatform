/*
Heap 을 써야만 할꺼 같았다...

Runtime - 891ms Beats 58.47%
Memory - 49.9MB Beats 96.72%
*/
class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val heap = PriorityQueue<HeapNode>()
        val ans = IntArray(temperatures.size) { 0 }
        for (idx in temperatures.indices) {
            while (heap.isNotEmpty() && heap.first().value < temperatures[idx]) {
                val entry = heap.poll()
                ans[entry.idx] = idx - entry.idx
            }
            heap.add(HeapNode(idx, temperatures[idx]))
        }
        return ans
    }
}

class HeapNode(val idx: Int, val value: Int) : Comparable<HeapNode> {
    override fun compareTo(other: HeapNode): Int = value - other.value
}

// 다 풀고 찾아보니 Stack 으로도 풀린다고 합니다..
// 왜 Heap 을 써야한다고 생각했지

/*
Runtime - 730ms Beats 90.44%
Memory - 52.3MB Beats 77.32%
*/
class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = mutableListOf<StackNode>()
        val ans = IntArray(temperatures.size) { 0 }
        for (idx in temperatures.indices) {
            while (stack.isNotEmpty() && stack.last().value < temperatures[idx]) {
                val entry = stack.removeAt(stack.size -1)
                ans[entry.idx] = idx - entry.idx
            }
            stack.add(StackNode(idx, temperatures[idx]))
        }
        return ans
    }
}

class StackNode(val idx: Int, val value: Int) : Comparable<StackNode> {
    override fun compareTo(other: StackNode): Int = value - other.value
}

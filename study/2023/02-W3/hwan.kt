/**
 * Java collections framework 의 LinkedHashMap (LinkedList + HashMap) 을 구현하는 과제
 *
 * 문제 조건상 value 가 음수인 경우는 고려하지 않는다.
 *
 * Runtime 1098ms, Beats 36.1%
 * Memory  136.3MiB, Beats 78.2%
 */
class LRUCache(private val capacity: Int) {
    private val nodes = LinkedList<Int>()
    private val entries = HashMap<Int, Int>()

    fun get(key: Int): Int {
        return (entries[key] ?: -1).also {
            // access 성공한 값은 promote 해야 한다
            if (it > -1) {
                promoteKey(key)
            }
        }
    }

    fun put(key: Int, value: Int) {
        // size 초과 위험 상황에서 새로운 값이 들어오면 가장 나중값을 evict 한다 (removeEldestEntry)
        if (entries.size >= capacity && !entries.containsKey(key)) {
            nodes.removeLast().let { entries.remove(it) }
        }

        putInternal(key, value)
    }

    private fun putInternal(key: Int, value: Int) {
        entries[key] = value
        promoteKey(key)
    }

    private fun promoteKey(key: Int) {
        nodes.remove(key)
        nodes.addFirst(key)
    }
}



@SmallTest
class TestRunner {
    @Test
    fun runTests() {
        val lRUCache = LRUCache(2)

        lRUCache.put(1, 1) // cache is {1=1}
        lRUCache.put(2, 2) // cache is {1=1, 2=2}

        assert(lRUCache.get(1) == 1) // return 1

        lRUCache.put(3, 3) // LRU key was 2, evicts key 2, cache is {1=1, 3=3}

        assert(lRUCache.get(2) == -1) // returns -1 (not found)

        lRUCache.put(4, 4) // LRU key was 1, evicts key 1, cache is {4=4, 3=3}

        assert(lRUCache.get(1) == -1) // return -1 (not found)

        assert(lRUCache.get(3) == 3) // return 3

        assert(lRUCache.get(4) == 4) // return 4
    }
}

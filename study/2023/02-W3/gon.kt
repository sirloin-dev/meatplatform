// 일부러 LinkedHashMap은 일부러 사용하지않았다.
// 더 빠르게 하고싶다면 LinkedHashSet이 아니라 자체적으로 o(n)으로 삭제와 삽입이 동시에 가능하게끔 하면 더 빨라질 여지가 있을것같다
    class LRUCache(val capacity: Int) {

        private val keySet: LinkedHashSet<Int> = LinkedHashSet()

        private val valMap = mutableMapOf<Int, Int>()

        fun get(key: Int): Int {
             return (valMap[key] ?: -1).also { 
                if (it > -1) {
                    keySet.remove(key)
                    keySet.add(key)
                }
            }
        }

        fun put(key: Int, value: Int) {
            if (valMap.size < capacity) {
                putVal(key, value)
            } else {
                if (!valMap.containsKey(key)) {
                    keySet.removeFirst()?.also {
                        valMap.remove(it)
                    }
                }
                putVal(key, value)
            }
        }

        private fun putVal(key: Int, value: Int) {
            keySet.remove(key)
            keySet.add(key)
            valMap[key] = value
        }

        private fun LinkedHashSet<Int>.removeFirst(): Int? {
            return if (this.isEmpty()) {
                null
            } else {
                return this.first().also {
                    this.remove(it)
                }
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

 fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
            if (source == destination) return true

            val map = mutableMapOf<Int, MutableList<Int>>()
            edges.forEach {
                map[it[0]] = map.getOrDefault(it[0], mutableListOf()).apply { add(it[1]) }
                map[it[1]] = map.getOrDefault(it[1], mutableListOf()).apply { add(it[0]) }
            }
            // map을 이용한 그래프 만들기

            val nextPath = mutableListOf<Int>() // 탐색예정 리스트
            val prePath = mutableSetOf<Int>() // 이미 탐색이 완료된 길
            nextPath.add(source)
            while (nextPath.isNotEmpty()) {
                val current = nextPath.removeAt(0) // 탐색지점
                if (prePath.contains(current)) continue
                prePath.add(current)
                val neighbors: List<Int> = (map[current] ?: return false)
                for (item in neighbors) {
                    if (item == destination) return true
                    nextPath.add(item)
                }
            }

            return false
        }

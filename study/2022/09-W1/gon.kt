fun wordPattern(pattern: String, s: String): Boolean {
        val split =s.split(" ")
        val map = mutableMapOf<String,String>()
        for (i in pattern.indices){
            map[pattern[i].toString()] = split[i]
        }

        if (split.toSet().size == 1) {
            if (map.keys.toSet().size > 1){
                return false
            }
        }

        for (i in pattern.indices){
            if (map[pattern[i].toString()] != split[i]) { return false }
        }
        return true
    }

// 오늘 발표인줄 모르고 바로 작성하느라 효율부분은 생각못하였습니다...

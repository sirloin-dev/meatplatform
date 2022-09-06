  /*
   * Runtime: 218 ms, faster than 61.16% of Kotlin online submissions for Word Pattern.
   * Memory Usage: 36 MB, less than 79.58% of Kotlin online submissions for Word Pattern.
   */
  fun wordPattern(pattern: String, s: String): Boolean {
      val words = s.split(" ")
      if (words.size != pattern.length) {
          return false
      }

      val memory1 = HashMap<Char, Int>()
      val memory2 = HashMap<String, Int>()

      /*
       * abba, dog cat cat dog
       *  1) (null) a : 0, (null) dog : 0   ->   { (a, 0) }        , { (dog, 0) }
       *  2) (null) b : 1, (null) cat : 1   ->   { (a, 0), (b, 1) }, { (dog, 0), (cat, 1) }
       *  3) (1)    b : 2, (1)    cat : 2   ->   { (a, 0), (b, 2) }, { (dog, 0), (cat, 2) }
       *  4) (0)    a : 3, (0)    dog : 3   ->   { (a, 3), (b, 2) }, { (dog, 3), (cat, 2) }
       */

      /*
       * abba, dog cat cat fish
       *  1) (null) a : 0, (null) dog  : 0   ->   { (a, 0) }        , { (dog, 0) }
       *  2) (null) b : 1, (null) cat  : 1   ->   { (a, 0), (b, 1) }, { (dog, 0), (cat, 1) }
       *  2) (1)    b : 2, (1)    cat  : 2   ->   { (a, 0), (b, 2) }, { (dog, 0), (cat, 2) }
       *  3) (3)    a : 3, (null) fish : 3   ->   3 != null 이므로 terminate
       */
      words.forEachIndexed { i, word ->
          val p = pattern[i]

          if (memory1.put(p, i) != memory2.put(word, i)) {
              return false
          }
      }

      return true
  }

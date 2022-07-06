fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        if (n == 0) {
            return
        }
        // index
        var totalIndex = m + n - 1
        var i = m - 1
        var j = n - 1

        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[totalIndex--] = nums2[j--];
            } else {
                nums1[totalIndex--] = nums1[i--];
            }
        }

        while (j >= 0) {
            nums1[totalIndex--] = nums2[j--];
        }
    }

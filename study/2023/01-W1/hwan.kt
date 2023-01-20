    /*
     * 완전한 number literal 외의 경우도 파싱해야 하는 경우가 있고,
     * 문제 시나리오의 overflow/underflow 규칙도 실제와 달라서 실용적이지는 않다
     * 또한 scientific notation (가령 1.23456e5) 같은 숫자도 제대로 인식하지 못한다.
     * 문제의 시나리오가 일부 올바른 숫자도 cover 하지 못하는 경우가 있음.
     *
     * Runtime: 195 ms, faster than 93.37% of Kotlin online submissions for String to Integer (atoi).
     * Memory Usage: 35.5 MB, less than 81.77% of Kotlin online submissions for String to Integer (atoi).
     */
    fun myAtoi(str: String): Int {
        var i = 0
        var sign = 1
        var acc = 0

        // 공백문자는 무시
        if (str.isEmpty()) {
            return acc * sign
        }

        while (i < str.length && str[i] == ' ') {
            ++i
        }

        // 공백문자만 만나서 이미 i 가 length 를 초과하는 경우가 있다면 종료
        if (i >= str.length) {
            return acc * sign
        }

        // sign 의 갯수와 무관하게 마지막으로 만난 양/음 기호가 최종 값에 영향을 미침
        if (str[i] == '-') {
            sign = -1
            ++i
        } else if (str[i] == '+') {
            sign = 1
            ++i
        }

        while (i < str.length && str[i] >= '0' && str[i] <= '9') {
            if (acc > Int.MAX_VALUE / 10 || acc == Int.MAX_VALUE / 10 && str[i] - '0' > 7) {
                return if (sign == 1) {
                    Int.MAX_VALUE
                } else {
                    Int.MIN_VALUE
                }
            }
            acc = acc * 10 + (str[i] - '0')
            ++i
        }

        return acc * sign
    }

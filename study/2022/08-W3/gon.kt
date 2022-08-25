/**
* 이진탐색 문제
* 중간 값을 기준으로 조회후 실패하면 조회 시작 지점을 앞으로 당김
* 성공하며 시작지점을 뒤로 미루 중간값을 기준으로 조회함
*/
class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var start = 1
        var last = n
        while (start <= last){
            var mid = start + (last-start)/2
            if (isBadVersion(mid)){
                last = mid-1
            }else{
                start = mid + 1
            }
        }
        return start
	}
}
